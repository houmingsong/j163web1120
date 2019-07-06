package com.lovo.j163web1120.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EL���ʽ��Expression Language
 * �﷨: ${�Ĵ�������ֿ�����ļ�ֵ}
 * ͨ�������ֵ��ȡ��Ӧ��ֵ�����ȡ�����Ƕ�����JAVA Bean���󣩣�ͨ�� .���� �ķ�ʽ��ȡ�������������ֵ 
 */
@WebServlet("/TestELServlet")
public class TestELServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("info", "request������");
		request.getSession().setAttribute("info", "session������");
		this.getServletContext().setAttribute("info", "application������");
		
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
