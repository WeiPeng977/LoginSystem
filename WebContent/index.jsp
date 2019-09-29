<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<style>
header {
	background-color: #F1F1F1;
	text-align: center;
	padding: 20px
}

nav {
	overflow: hidden;
	background-color: #888;
}

aside {
	float: left;
	width: 15%;
	height: 652px;
	background-color: #bbb;
}

footer {
	text-align: center;
	padding: 20px;
	background-color: #F1F1F1;
}

section {
	width: 85%;
	height: 652px;
}

body {
	margin: 0px;
}
</style>
<script>
function logout() {
    document.from.action = "logout";//提交的url
    document.from.submit();
}<!--注销，对应UserServlet.java中的logout方法-->
function signout() {
    document.from.action = "signout";//提交的url
    document.from.submit();
}<!--注销，对应UserServlet.java中的signout方法-->
function modify() {
    document.from.action = "Modify.jsp";//提交的url
    document.from.submit();
}<!--修改页面-->
</script>
</head>
<body>
	<%
		String id = session.getId();
	%>
	<%
		String userName = (String) session.getAttribute("userName");
		if (userName == null) {
			// 弹窗提示+页面跳转
			response.sendRedirect("LoginCheck.jsp");
		}
	%>
	<header>
		Welcome!
		<%=userName%>
		you have come to the right place. Your session id is
		<%=id%></header>
	<nav>nav</nav>
	<aside>
		<form name="from" method="post">
			<ul>
				<li><input type="button" value="logout" onclick="logout()"
					style="width: 80px;" /></li>
				<li><input type="button" value="signout" onclick="signout()"
					style="width: 80px;" /></li>
				<li><input type="button" value="modify" onclick="modify()"
					style="width: 80px;" /></li>
			</ul>
		</form>
	</aside>
	<section>
		<iframe></iframe>
	</section>
	<footer>&copyfooter</footer>
</body>
</html>