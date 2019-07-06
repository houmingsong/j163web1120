package com.lovo.j163web1120.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.lovo.j163web1120.bean.PaginationBean;
import com.lovo.j163web1120.bean.UserBean;
import com.lovo.j163web1120.service.UserService;
import com.lovo.j163web1120.service.impl.UserServiceImpl;

/**
 * Servlet implementation class PaginationServlet
 */
@WebServlet("/AjaxPaginationServlet")
public class AjaxPaginationServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String currPage = request.getParameter("currPage");
		Integer currPageNum = Integer.parseInt(currPage);
		
		UserService userService = new UserServiceImpl();
		
		Integer totalPage = userService.getTotalPage();
		
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
		
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), pageBean);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
