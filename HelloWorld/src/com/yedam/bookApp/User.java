package com.yedam.bookApp;

public class User {
	private String userid;
	private String userName;
	private String password;
	
	public User(String userid, String username, String password) {
		this.userid = userid;
		this.userName = username;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}