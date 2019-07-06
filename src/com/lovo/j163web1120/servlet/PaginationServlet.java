package com.lovo.j163web1120.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.j163web1120.bean.PaginationBean;
import com.lovo.j163web1120.bean.UserBean;
import com.lovo.j163web1120.service.UserService;
import com.lovo.j163web1120.service.impl.UserServiceImpl;

/**
 * Servlet implementation class PaginationServlet
 */
@WebServlet("/paginationServlet")
public class PaginationServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String operator = request.getParameter("operator");
		String currPage = request.getParameter("currPage");
		
		if (currPage == null || currPage.length() == 0) {
			currPage = "1";
		}
		
		Integer currPageNum = Integer.parseInt(currPage);
		
		UserService userService = new UserServiceImpl();
		
		Integer totalPage = userService.getTotalPage();
		
		if (operator == null || operator.length() == 0) {
			currPageNum = 1;
		} else if ("首页".equals(operator)) {
			currPageNum = 1;
		} else if ("上一页".equals(operator)) {
			currPageNum = currPageNum - 1;
		} else if ("下一页".equals(operator)) {
			currPageNum = currPageNum + 1;
		} else {
			currPageNum = totalPage;
		}
		
		if (currPageNum < 1) {
			currPageNum = 1;
		}
		
		if (currPageNum > totalPage) {
			currPageNum = totalPage;
		}
		
		List<UserBean> userList = userService.getUserListByCurrPage(currPageNum);
		
		PaginationBean<UserBean> pageBean = new PaginationBean<UserBean>();
		pageBean.setDataList(userList);
		pageBean.setCurrPage(currPageNum);
		pageBean.setTotalPage(totalPage);
		
		request.setAttribute("pageBean", pageBean);
		
		request.getRequestDispatcher("/userList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
