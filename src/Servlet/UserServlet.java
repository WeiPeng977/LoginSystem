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
        //接收请求后判断所需执行的方法
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/register":
                    register(request, response);
                    break;

                case "/login":
                    login(request, response);
                    break;

                case "/modify":
                    modify(request, response);
                    break;

                case "/logout":
                    logout(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        //创建info列表来存储用户名和密码为空时所要展示的信息
        List<String> info = new ArrayList<String>();

        if (userName == null || "".equals(userName)) {
            info.add("username can not be empty");
            PrintWriter out = response.getWriter();
            //弹窗提示+页面跳转
            out.print("<script language='javascript'>alert('username can not be empty!'); window.location.href='index.jsp'</script>");
        }

        if (password == null || "".equals(password)) {
            info.add("password can not be empty ");
            PrintWriter out = response.getWriter();
            //弹窗提示+页面跳转
            out.print("<script language='javascript'>alert('password can not be empty!'); window.location.href='index.jsp'</script>");
        }

        User existingUser = userDao.readUser(userName);

        if (info.size() == 0) {
            if (existingUser == null) {
                PrintWriter out = response.getWriter();
                //弹窗提示+页面跳转
                out.print("<script language='javascript'>alert('login failed! user does not exists'); window.location.href='index.jsp'</script>");
            } else {

                if (password.equals(existingUser.getPassword())) {
                    //将用户名和密码传到用户页面user.jsp中
                    request.setAttribute("userName", userName);
                    request.setAttribute("password", password);
                    request.getRequestDispatcher("user.jsp").forward(request, response);

                } else {
                    PrintWriter out = response.getWriter();
                    //弹窗提示+页面跳转
                    out.print("<script language='javascript'>alert('login failed! wrong password'); window.location.href='index.jsp'</script>");
                }
            }
        }
    }


    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //接收参数
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        //判断用户名和密码是否为空
        List<String> info = new ArrayList<String>();

        if (username == null || "".equals(username)) { //用户名输入格式问题
            info.add("username can not be empty!");
            PrintWriter out = response.getWriter();
            //弹窗提示+跳转页面
            out.print("<script language='javascript'>alert('username can not be empty!'); window.location.href='register.jsp'</script>");
        }

        if (password == null || "".equals(password)) {//密码输入格式问题
            info.add("password can not be empty!");
            PrintWriter out = response.getWriter();
            //弹窗提示+跳转页面
            out.print("<script language='javascript'>alert('password can not be empty!'); window.location.href='register.jsp'</script>");
        }

        if (info.size() == 0) {

            //判断用户名是否存在
            User existingUser = userDao.readUser(username);

            if (existingUser == null) {
                //创建新用户
                User user = new User();
                user.setUserName(username);
                user.setPassword(password);
                try {
                    userDao.createUser(user);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //创建成功
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('register successful!'); window.location.href='index.jsp'</script>");
            } else {
                //创建失败
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('user already exists!'); window.location.href='register.jsp'</script>");
            }

        }
    }

    private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收参数
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        //判断密码是否为空
        List<String> info = new ArrayList<String>();


        if (password == null || "".equals(password)) {//密码输入格式问题
            info.add("password can not be empty!");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('password can not be empty!'); window.location.href='register.jsp'</script>");
        }

        if (info.size() == 0) {
            //执行修改
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            try {
                userDao.updateUser(user);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //修改成功
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('modify successful!'); window.location.href='index.jsp'</script>");
        }


    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        //接收参数
        String userName = request.getParameter("userName");

        //执行删除
        userDao.deleteUser(userName);

        //删除成功
        PrintWriter out = response.getWriter();
        out.print("<script language='javascript'>alert('logout successful!'); window.location.href='index.jsp'</script>");
    }
}
