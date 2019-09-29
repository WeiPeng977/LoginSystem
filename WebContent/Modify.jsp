<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Modify</title>
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

td {
	padding: 3px;
}
</style>
<script type="text/javascript">
    function modify() {
        document.from.action = "modify";//提交的url
        document.from.submit();
    }<!--修改，对应UserServlet.jsp中的modify方法，用户名通过url传参，密码通过表单传参-->
    function index() {
        document.from.action = "index.jsp";//提交的url
        document.from.submit();
    }
</script>
</head>
<body>
	<%
		String userName = (String) session.getAttribute("userName");
		if (userName == null) {
			// 页面跳转
			response.sendRedirect("LoginCheck.jsp");
		}
	%>
	<div align="center">
		<!-- 调整页面上边距 -->

		<form style="margin-top: 280px;" name="from" method="post">
			<fieldset
				style="width: 200px; border: 2px solid dimgray; border-radius: 8px";">
				<legend align="center"
					style="margin: -20px; padding: 10px; font-size: 43px; font-family: Times New Roman, Times, serif; align: center">
					<sup>ModifyPage</sup>
				</legend>
				<table>
					<tr>
						<td><input class="inp" type="text" name="userName"
							value="<%=userName%>" readonly="readonly" /></td>
					</tr>
					<tr>
						<td><input class="inp" type="password" name="password"
							placeholder="Password" autofocus="autofocus"/></td>
					</tr>
					<tr>
						<td align="center"><input class="btn" type="button"
							value="modify" onclick="modify()" />&nbsp&nbsp&nbsp<input
							class="btn" type="button" value="index" onclick="index()" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>