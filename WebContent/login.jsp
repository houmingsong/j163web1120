<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
</head>
<body>
	<form action="loginServlet" method="post">
		用户名：<input type="text" name="username"><br><br>
		密码：<input type="password" name="pwd"><br><br>
		<input type="submit" name="btn" value="登录">
	</form>
</body>
</html>