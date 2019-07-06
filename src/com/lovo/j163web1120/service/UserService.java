package com.lovo.j163web1120.service;

import java.util.List;

import com.lovo.j163web1120.bean.UserBean;

public interface UserService {
	
	public List<UserBean> getUserListByCurrPage(Integer currPage);
	
	public Integer getTotalPage();
}
