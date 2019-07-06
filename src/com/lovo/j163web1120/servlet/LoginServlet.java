package com.lovo.j163web1120.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lovo.j163web1120.bean.UserBean;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("pwd");
		
		
		if ("ÕÅÈý".equals(username) && "123456".equals(password)) {
			UserBean userBean = new UserBean();
			userBean.setUsername(username);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", userBean);
			
			request.getRequestDispatcher("/loginStatus.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
