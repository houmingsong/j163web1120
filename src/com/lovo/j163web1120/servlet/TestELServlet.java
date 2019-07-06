package com.lovo.j163web1120.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EL表达式：Expression Language
 * 语法: ${四大作用域仓库里面的键值}
 * 通过这个键值获取对应的值，如果取出的是对象（如JAVA Bean对象），通过 .属性 的方式获取对象里面的属性值 
 */
@WebServlet("/TestELServlet")
public class TestELServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("info", "request作用域");
		request.getSession().setAttribute("info", "session作用域");
		this.getServletContext().setAttribute("info", "application作用域");
		
		request.getRequestDispatcher("/getInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
