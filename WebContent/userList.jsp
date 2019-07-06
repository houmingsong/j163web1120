<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%-- 引入jstl标记库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head lang="en">
	<meta charset="utf-8">
	<title>分页查询</title>
	<style type="text/css">
		table {
			border: 1px solid black;
			border-collapse: collapse;
		}
		table tr th {
			border: 1px solid black;
		}
		table tr td {
			border: 1px solid black;
		}
	</style>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${pageBean.dataList }" var="u">
			<tr>
				<td>${u.id }</td>
				<td>${u.username }</td>
				<td>${u.sex }</td>
				<td>${u.age }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<form action="paginationServlet" method="get">
		<input type="submit" name="operator" value="首页">
		<input type="submit" name="operator" value="上一页">
		<input type="submit" name="operator" value="下一页">
		<input type="submit" name="operator" value="尾页">
		<span>第${pageBean.currPage }页，共${pageBean.totalPage }页</span>
		<input type="hidden" name="currPage" value="${pageBean.currPage }">
	</form>
</body>
</html>