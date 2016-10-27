package com.hxuhao.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String sex;

	public User() {

	}

	public User(String name, String pwd, String sex1) {
		username = name;
		password = pwd;
		sex = sex1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + "]";
	}

}
