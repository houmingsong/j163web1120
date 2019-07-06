package com.lovo.j163web1120.bean;

public class UserBean {
	
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	
	private String sex;
	
	private int age;
	
//	private Gun gun;
	
	public UserBean() {
		
	}
	
	public UserBean(Integer id, String username, String sex, int age) {
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.age = age;
	}

	public UserBean(Integer id, String username, String sex, int age, Gun gun) {
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.age = age;
//		this.gun = gun;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", sex=" + sex + ", age=" + age + "]";
	}

//	public Gun getGun() {
//		return gun;
//	}
//
//	public void setGun(Gun gun) {
//		this.gun = gun;
//	}
	
}
