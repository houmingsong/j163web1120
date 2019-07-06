<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.lovo.j163web1120.bean.Gun"%>
<%@page import="com.lovo.j163web1120.bean.UserBean"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%-- 引入jstl标记库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head lang="en">
	<meta charset="utf-8">
	<title>EL表达式取值</title>
</head>
	<%
// 		pageContext.setAttribute("info", "page作用域");
// 		request.setAttribute("info", "request作用域");
// 		session.setAttribute("info", "session作用域");
// 		application.setAttribute("info", "application作用域");

// 		UserBean userBean = new UserBean();
// 		userBean.setId(1);
// 		userBean.setUsername("张三");
// 		userBean.setAge(20);
// 		Gun gun = new Gun();
// 		gun.setGunName("AK47");
// 		userBean.setGun(gun);
		
// 		pageContext.setAttribute("user", userBean);
		
		
		List list = new ArrayList();
		list.add("李四");
		list.add("www.lovo.cn");
		list.add("zhangsan@163.com");
		request.setAttribute("list", list);
		
		List<UserBean> userList = new ArrayList<UserBean>();
		UserBean user1 = new UserBean(1, "张三", "男", 22, new Gun("AK47"));
		UserBean user2 = new UserBean(2, null, "男", 45, new Gun("M16"));
		UserBean user3 = new UserBean(3, "萨达姆", "男", 50, new Gun("八一杠幺"));
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		request.setAttribute("users", userList);
		
		Map map = new HashMap();
		map.put("chengdu", "成都");
		map.put("mianyang", "绵阳");
		map.put("leshan", "乐山");
		request.setAttribute("map", map);
		
		Date currDate = new Date();
		request.setAttribute("currDate", currDate);
	%>
<body>
	<%-- <h4>page作用域：${pageScope.info }</h4>
	<h4>request作用域：${requestScope.info }</h4>
	<h4>session作用域：${sessionScope.info }</h4>
	<h4>application作用域：${applicationScope.info }</h4>
	<!-- 这种写法最常用 -->
	<h4>XXX作用域：${info }</h4>
	
	<hr>
	<h2>获取复杂对象的属性值</h2>
	<h4>获取UserBean对象的username值：${user.username }, 他的实际年龄是：${user.age + 20 }, 实际年龄是否小于50岁：${user.age < 50 }</h4>
	<h4>获取UserBean对象的Gun里面的gunName值：${user.gun.gunName }</h4>
	
	<hr>
	<h2>取list里面的元素</h2>
	<h4>第一个元素：${list[0] }</h4>
	<h4>第二个元素：${list[1] }</h4>
	<h4>第三个元素：${list[2] }</h4>
	
	<hr>
	<h2>取map里面的元素</h2>
	<h4>第一个键值对的值：${map.chengdu }</h4>
	<h4>第二个键值对的值：${map.mianyang }</h4>
	<h4>第三个键值对的值：${map.leshan }</h4>
	<h4>判断是否是空值：${empty map.leshan}</h4> --%>
	
	<hr>
	<h2>遍历list里面的元素</h2>
	<%-- <c:forEach items="${list }" var="e">
		${e } <br>
	</c:forEach> --%>
	<table border=1>
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>拥有武器</th>
			<th></th>
		</tr>
		<c:forEach items="${users }" var="u">
<%-- 			<c:if test="${u.age > 22 }"> --%>
			<c:if test="${not empty u.username }">
				<tr>
					<td>${u.id }</td>
					<td>${u.username }</td>
					<td>${u.sex }</td>
					<td>${u.age }</td>
					<td>${u.gun.gunName }</td>
					<td><a href="showDetailServlet?id=${u.id }">查看详情</a></td>
				</tr>
			</c:if>	
		</c:forEach>
	</table>
	
	<hr>
	<h2>遍历map里面的元素</h2>
	<c:forEach items="${map }" var="e">
		${e.key } - ${e.value } <br>
	</c:forEach>
	
	<h1>
		<fmt:formatDate value="${currDate}" pattern="yyyy-MM-dd"/>
	</h1>
</body>
</html>