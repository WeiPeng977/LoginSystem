<%--
  Created by IntelliJ IDEA.
  User: wangweipeng
  Date: 2019-08-13
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify</title>
</head>
<body>
<div align="center">
    <!-- 调整页面上边距 -->
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

    <h1>ModifyPage</h1>
    <form name="from" method="post">
        <table>
            <tr>
                <td><p width="200px" align="left" id="userName"></p></td>
            </tr>
            <tr>
                <td><input type="password" name="password" placeholder="Password" style="width: 200px;"/></td>
            </tr>
            <tr>
                <td align="center">
                    <input type="button" value="modify" onclick="modify()" style="width: 170px;"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<!--按钮执行的函数，为了使表单中不同的按钮可以执行不同的方法，所以将提交表单的方法卸载函数中-->
<script type="text/javascript">
    function modify() {
        document.from.action = "modify?userName=" + getQueryVariable("userName");//提交的url
        document.from.submit();
    }<!--修改，对应UserServlet.jsp中的modify方法，用户名通过url传参，密码通过表单传参-->

    <!--解析url参数的方法-->
    function getQueryVariable(variable) {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i = 0; i < vars.length; i++) {
            var pair = vars[i].split("=");
            if (pair[0] == variable) {
                return pair[1];
            }
        }
        return (false);
    }
    <!--将从URL中解析出来的参数填入id为userName的元素中-->
    document.getElementById("userName").innerHTML = "userName:" + getQueryVariable("userName");
</script>
</body>
</html>
