package com.hxuhao.service;

import com.hxuhao.model.User;

public interface IUserService {
	public User getUserByName(String name);

	public User getUserById(int id);

	public void createUser(User user);
}
