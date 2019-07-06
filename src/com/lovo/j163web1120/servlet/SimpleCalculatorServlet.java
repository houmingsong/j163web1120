package com.lovo.j163web1120.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleCalculatorServlet
 */
@WebServlet("/SimpleCalculatorServlet")
public class SimpleCalculatorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Integer firstNum = Integer.valueOf(request.getParameter("firstNum"));
		String operator = request.getParameter("operator");
		Integer secondNum = Integer.valueOf(request.getParameter("secondNum"));
		
		float result = 0.0f;
		
		if ("+".equals(operator)) {
			
			result = firstNum + secondNum;
			
		} else if ("-".equals(operator)) {
			
			result = firstNum - secondNum;
			
		} else if ("*".equals(operator)) {
			
			result = firstNum * secondNum;
			
		} else if ("/".equals(operator)) {
			
			result = firstNum / secondNum;
		}
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/SimpleCalculator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
