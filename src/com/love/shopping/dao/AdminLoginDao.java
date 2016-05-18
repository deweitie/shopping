package com.love.shopping.dao;

import com.love.shopping.po.Admin;


public interface AdminLoginDao {

	public boolean login(Admin admin);
	public boolean updatePassword(Admin admin);
}
