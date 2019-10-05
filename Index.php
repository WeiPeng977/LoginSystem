<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index</title>
    <script>
        function logout() {
            document.from.action = "logout.php";//提交的url
            document.from.submit();
        }<!--注销，对应UserServlet.java中的logout方法-->
        function signout() {
            document.from.action = "signout.php";//提交的url
            document.from.submit();
        }<!--注销，对应UserServlet.java中的signout方法-->
        function modify() {
            document.from.action = "ModifyPage.php";//提交的url
            document.from.submit();
        }<!--修改页面-->
    </script>
</head>
<body>

<?php
session_start();
if($_SESSION['userName'] == null){
echo "<script language='JavaScript'>window.location.href='LoginPage.php'</script>";
}
echo "Hello!&nbsp" . $_SESSION['userName'];
?>
<form name="from" method="post">
    <ul>
        <li><input type="button" value="logout" onclick="logout()"
                   style="width: 80px;"/></li>
        <li><input type="button" value="signout" onclick="signout()"
                   style="width: 80px;"/></li>
        <li><input type="button" value="modify" onclick="modify()"
                   style="width: 80px;"/></li>
    </ul>
</form>
</body>
</html>