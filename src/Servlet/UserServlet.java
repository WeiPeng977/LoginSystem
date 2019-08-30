package Servlet;

import Classes.User;
import Dao.UserDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/create":
                    createUser(request, response);
                    break;

                case "/read":
                    readUser(request, response);
                    break;

                case "/login":
                    loginVerify(request, response);
                    break;

                case "/update":
                    updateUser(request, response);
                    break;

                case "/delete":
                    deleteUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void loginVerify(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        List<String> info=new ArrayList<String>();

        if(userName==null||"".equals(userName)){ //用户名输入格式问题
            info.add("用户名不能为空");
            System.out.println("用户名不能为空");
        }

        if(password==null||"".equals(password)){//密码输入格式问题
            info.add("密码不能为空");
            System.out.println("密码不能为空");
        }

        User existingUser = userDao.readUser(userName);

        if(info.size()==0){
            if(password.equals(existingUser.getPassword())){
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('login successful!'); window.location.href='user.jsp'</script>");
            }else{
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('register failed!'); window.location.href='index.jsp'</script>");
            }
        }
    }


    private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        User User = new User();
        User.setUserName(username);
        User.setPassword(password);
        try {
            userDao.createUser(User);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.print("<script language='javascript'>alert('register successful!'); window.location.href='index.jsp'</script>");
    }

    private void readUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        User existingUser = userDao.readUser(userName);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>" + existingUser.getUserName()
                + "<br/>" + existingUser.getPassword()
                + "<h1>");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

    }
}
