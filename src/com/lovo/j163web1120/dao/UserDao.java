package com.lovo.j163web1120.dao;

import java.util.List;

import com.lovo.j163web1120.bean.UserBean;

public interface UserDao {
	
	public List<UserBean> getUserListByCurrPage(Integer currPage);
	
	public int getTotalCount();

}
