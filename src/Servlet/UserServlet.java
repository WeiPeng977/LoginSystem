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

        switch (action) {
            case "/create":
                createUser(request, response);
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
    }

    private void loginVerify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        List<String> info = new ArrayList<String>();

        if (userName == null || "".equals(userName)) {
            info.add("username can not be empty");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('username can not be empty!'); window.location.href='index.jsp'</script>");
        }

        if (password == null || "".equals(password)) {
            info.add("password can not be empty ");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('password can not be empty!'); window.location.href='index.jsp'</script>");
        }

        User existingUser = userDao.readUser(userName);

        if (info.size() == 0) {
            if (password.equals(existingUser.getPassword())) {
                request.setAttribute("userName", userName);
                request.setAttribute("password", password);
                request.getRequestDispatcher("user.jsp").forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('login failed!'); window.location.href='index.jsp'</script>");
            }
        }
    }


    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        List<String> info = new ArrayList<String>();

        if (username == null || "".equals(username)) { //用户名输入格式问题
            info.add("username can not be empty!");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('username can not be empty!'); window.location.href='register.jsp'</script>");
        }

        if (password == null || "".equals(password)) {//密码输入格式问题
            info.add("password can not be empty!");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('password can not be empty!'); window.location.href='register.jsp'</script>");
        }

        if (info.size() == 0) {

            User existingUser = userDao.readUser(username);

            if (existingUser == null) {
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
            } else {
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('user already exists!'); window.location.href='register.jsp'</script>");
            }

        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {

    }
}
