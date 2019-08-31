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
    <h1>ModifyPage</h1>
    <form name="from" method="post">
        <table>
            <tr>
                <td><p width="200px" align="left" id = "userName"></p></td>
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
<script type="text/javascript">
    function modify() {
        document.from.action = "update?userName=" + getQueryVariable("userName");//提交的url
        document.from.submit();
    }

    function getQueryVariable(variable)
    {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            if(pair[0] == variable){return pair[1];}
        }
        return(false);
    }

    document.getElementById("userName").innerHTML = "userName:" + getQueryVariable("userName");
</script>
</body>
</html>
