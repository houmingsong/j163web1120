<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head lang="en">
	<meta charset="utf-8">
	<title>简单的计算器</title>
</head>
<body>
<hr>
计算结果：<%-- <%= (Float)request.getAttribute("result") %> --%> ${result}
<hr>
<form action="SimpleCalculatorServlet" method="post">
<table border="1">
	<tr><td colspan="2">简单的计算器</td></tr>
	<tr>
		<td>第一个操作数</td>
		<td><input type=text name="firstNum"></td>
	</tr>
	<tr>
		<td>操作符</td>
		<td>
			 <select name="operator">
			 	<option value="+">+</option>
			 	<option value="-">-</option>
			 	<option value="*">*</option>
			 	<option value="/">/</option>
			 </select>	
		</td>
	</tr>
	<tr>
		<td>第二个操作数</td>
		<td><input type=text name="secondNum"></td>
	</tr>
	<tr>
		<td colspan="2"><input type=submit value=计算></td>
	</tr>	
</table>
</form>
</body>
</html>