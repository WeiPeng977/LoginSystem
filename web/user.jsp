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
        <table align="center">
            <tr>
                <td width="100px" align="right"><p>userName:</p></td>
                <td width="100px" align="left"><p>aPeng977</p></td>
            </tr>
            <tr>
                <td width="100px" align="right"><p>password:</p></td>
                <td width="100px" align="left"><p>12345678</p></td>
            </tr>
            <tr>
                <td align="right"><input type="button" value="modify" onclick="modify()" style="width: 80px;"/></td>
                <td align="left"><input type="button" value="logout" onclick="logout()" style="width: 80px;"/></td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    function modify() {
        document.from.action = "modify.jsp";//提交的url
        document.from.submit();
    }

    function logout() {
        document.from.action = "your delete method url";//提交的url
        document.from.submit();
    }
</script>
</body>
</html>
