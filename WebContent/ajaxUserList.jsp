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
<script type="text/javascript" src="jquery-2.1.4.js"></script>	
<script type="text/javascript">
	$(function(){
		var currPage = 1;
		$.getJSON("AjaxPaginationServlet", {currPage:currPage}, fillData);
		
		$("input[type=button]").click(function(){
			var operation = this.value;
			currPage = parseInt($("input[name=currPage]").val());
			var totalPage = $("input[name=totalPage]").val();
			
			if (operation == "首页") {
				
				currPage = 1;
			} else if(operation == "上一页"){
				
				currPage = currPage - 1;
			} else if(operation == "下一页"){
				
				currPage = currPage + 1;
			} else {//尾页
				
				currPage = totalPage;
			}
			
			$.getJSON("AjaxPaginationServlet", {currPage:currPage}, fillData);
		});
	});
	
	function fillData(data){
		var $table = $("table");
		$table.empty();
		var head = "<tr><th>ID</th><th>姓名</th><th>性别</th><th>年龄</th></tr>";
		$table.append(head);
		
		$.each(data.dataList, function(i, e){
			var id = e.id;
			var username = e.username;
			var sex = e.sex;
			var age = e.age;
			
			var tr = "<tr><td>" + id + "</td><td>" + username + "</td><td>" + sex + "</td><td>" + age + "</td></tr>";
			$table.append(tr);
		});
		
		$("input[name=currPage]").val(data.currPage);
		$("input[name=totalPage]").val(data.totalPage);
		$("span").html("第" + data.currPage + "页，共" + data.totalPage + "页");
	}
</script>
</head>
<body>
	<table>
	</table>
	<br>
	<br>
	
	<input type="button" name="operator" value="首页">
	<input type="button" name="operator" value="上一页">
	<input type="button" name="operator" value="下一页">
	<input type="button" name="operator" value="尾页">
	<span></span>
	<input type="hidden" name="currPage">
	<input type="hidden" name="totalPage">
</body>
</html>