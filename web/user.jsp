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
    <title>User</title>
</head>
<body>
<div align="center">
    <h1>UserPage</h1>
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
                    <input type="button" value="modify" onclick="modify()"  style="width: 80px;"/>
                    <input type="button" value="logout" onclick="logout()"  style="width: 80px;"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    function modify(){
        document.from.action="your add method url";//提交的url
        document.from.submit();
    }

    function logout(){
        document.from.action="your delete method url";//提交的url
        document.from.submit();
    }
</script>
</body>
</html>
