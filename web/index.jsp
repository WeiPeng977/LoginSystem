<%--
  Created by IntelliJ IDEA.
  User: wangweipeng
  Date: 2019-08-13
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div align="center">
    <!-- 调整页面上边距 -->
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

    <h1>LoginPage</h1>
    <form name="from" method="post">
        <!--表格，三行一列，宽度200px-->
        <table>
            <tr>
                <td><input type="text" name="userName" placeholder="UserName" style="width: 200px;"/></td>
            </tr>
            <tr>
                <td><input type="password" name="password" placeholder="Password" style="width: 200px;"/></td>
            </tr>
            <tr>
                <td align="center">
                    <input type="button" value="login" onclick="login()" style="width: 80px;"/>
                    <input type="button" value="register" onclick="register()" style="width: 80px;"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<!--按钮执行的函数，为了使表单中不同的按钮可以执行不同的方法，所以将提交表单的方法卸载函数中-->
<script type="text/javascript">
    function login() {
        document.from.action = "login";//提交的url
        document.from.submit();
    }<!--登录，对应UserServlet.java中的login方法-->

    function register() {
        document.from.action = "register.jsp";//提交的url
        document.from.submit();
    }<!--注册页面-->
</script>
</body>
</html>
