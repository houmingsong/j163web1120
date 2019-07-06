package com.lovo.j163web1120.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lovo.j163web1120.bean.UserBean;
import com.lovo.j163web1120.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public List<UserBean> getUserListByCurrPage(Integer currPage) {
		
		List<UserBean> userList = new ArrayList<UserBean>();
		
		try {
			
			Integer startIndex = (currPage-1)*5;
			
			this.openConnection();
			
			this.ps = this.conn.prepareStatement("select * from t_user1 limit ?, 5");
			this.ps.setInt(1, startIndex);
			
			this.rs = this.ps.executeQuery();
			
			while(this.rs.next()) {
				Integer id = this.rs.getInt("pk_id");
				String username = this.rs.getString("f_username");
				String sex = this.rs.getString("f_sex");
				Integer age = this.rs.getInt("f_age");
				
				UserBean userBean = new UserBean(id, username, sex, age);
				
				userList.add(userBean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			this.close();
		}
		
		return userList;
	}

	@Override
	public int getTotalCount() {
		
		int totalCount = 0;
		
		try {
			
			this.openConnection();
			
			this.ps = this.conn.prepareStatement("select count(*) from t_user1");
			
			this.rs = this.ps.executeQuery();
			
			if (this.rs.next()) {
				totalCount = this.rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			this.close();
		}
		
		return totalCount;
	}
	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl();
		System.out.println(dao.getUserListByCurrPage(1));
	}
}
