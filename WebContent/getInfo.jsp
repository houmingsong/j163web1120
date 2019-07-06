<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.lovo.j163web1120.bean.Gun"%>
<%@page import="com.lovo.j163web1120.bean.UserBean"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head lang="en">
	<meta charset="utf-8">
	<title>EL表达式取值</title>
</head>
	<%
		pageContext.setAttribute("info", "page作用域");
		request.setAttribute("info", "request作用域");
		session.setAttribute("info", "session作用域");
		application.setAttribute("info", "application作用域");

		UserBean userBean = new UserBean();
		userBean.setId(1);
		userBean.setUsername("张三");
		userBean.setAge(20);
		Gun gun = new Gun();
		gun.setGunName("AK47");
// 		userBean.setGun(gun);
		
		pageContext.setAttribute("user", userBean);
		
		
		List list = new ArrayList();
		list.add("李四");
		list.add("www.lovo.cn");
		list.add("zhangsan@163.com");
		request.setAttribute("list", list);
		
		Map map = new HashMap();
		map.put("chengdu", "成都");
		map.put("mianyang", "绵阳");
		map.put("leshan", "乐山");
		request.setAttribute("map", map);
	%>
<body>
	<h4>page作用域：${pageScope.info }</h4>
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
	<h4>判断是否是空值：${empty map.leshan}</h4>
</body>
</html>