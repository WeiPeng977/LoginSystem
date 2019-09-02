<%--
  Created by IntelliJ IDEA.
  User: wangweipeng
  Date: 2019-08-13
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div align="center">

    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

    <h1>RegisterPage</h1>
    <form name="from" method="post">
        <table>
            <tr>
                <td><input type="text" name="userName" placeholder="UserName" style="width: 200px;"/></td>
            </tr>
            <tr>
                <td><input type="password" name="password" placeholder="Password" style="width: 200px;"/></td>
            </tr>
            <tr>
                <td align="center">
                    <input type="button" value="register" onclick="register0()"  style="width: 80px;"/>
                    <input type="button" value="login" onclick="login()" style="width: 80px;"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">

    function login() {
        document.from.action = "index.jsp";//提交的url
        document.from.submit();
    }

    function register0(){
        document.from.action="register";//提交的url
        document.from.submit();
    }
</script>
</body>
</html>
