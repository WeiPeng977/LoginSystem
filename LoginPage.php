<!DOCTYPE html>
<?php
session_start();
?>
<html>
<head>
    <meta charset="UTF-8">
    <title>LoginPage</title>
    <style type="text/css">
        .inp {
            border: 2px solid dimgray;
            border-radius: 4px;
            width: 200px;
            height: 20px;
            font-size: 20px;
            border-radius: 4px;
            border-radius: 4px;
        }

        .btn {
            width: 90px;
            border: 2px solid dimgray;
            border-radius: 5px;
        }
        td{
            padding:3px;
        }
    </style>
    <script type="text/javascript">
        function login() {
            document.from.action = "loginCheck.php";//提交的url
            document.from.submit();
        }<!--登录s对应UserServlet.java中的login方法-->

        function register() {
            document.from.action = "RegisterPage.html";//提交的url
            document.from.submit();
        }<!--注册页面-->
    </script>
</head>
<body>
<div align="center">
    <!-- 调整页面上边距 -->

    <form style="margin-top:280px;" name="from" method="post">
        <fieldset style="width: 200px;border:2px solid dimgray; border-radius: 8px;">
            <legend align="center"
                    style="margin: -20px; padding: 10px; font-size: 43px; font-family: Times New Roman, Times, serif; align: center">
                <sup>LoginPage</sup>
            </legend>
            <table>
                <tr>
                    <td><input class="inp" type="text" name="userName"
                               placeholder="UserName" autofocus="autofocus"/></td>
                </tr>
                <tr>
                    <td><input class="inp" type="password" name="password"
                               placeholder="Password" /></td>
                </tr>
                <tr>
                    <td align="center"><input class="btn" type="button"
                                              value="login" onclick="login()" />&nbsp&nbsp&nbsp<input
                            class="btn" type="button" value="register" onclick="register()" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>