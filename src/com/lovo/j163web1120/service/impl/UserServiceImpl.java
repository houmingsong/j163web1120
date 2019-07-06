package com.lovo.j163web1120.service.impl;

import java.util.List;

import com.lovo.j163web1120.bean.UserBean;
import com.lovo.j163web1120.dao.UserDao;
import com.lovo.j163web1120.dao.impl.UserDaoImpl;
import com.lovo.j163web1120.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public List<UserBean> getUserListByCurrPage(Integer currPage) {
		
		List<UserBean> userList = userDao.getUserListByCurrPage(currPage);
		
		return userList;
	}

	@Override
	public Integer getTotalPage() {
		
		int totalCount = userDao.getTotalCount();
		
		Integer totalPage = (totalCount + 5 - 1)/5;
		
		return totalPage;
	}

}
