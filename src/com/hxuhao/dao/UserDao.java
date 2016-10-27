package com.hxuhao.dao;

import com.hxuhao.model.User;

public interface UserDao {
	void createUser(User user);

	User getUserByName(String name);

	User getUserById(int id);
}
