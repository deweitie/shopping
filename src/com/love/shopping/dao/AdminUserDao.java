package com.love.shopping.dao;

import java.util.List;
import java.util.Map;

import com.love.shopping.po.UserPager;


public interface AdminUserDao {

	public Map getAllUsers();   //显示用户
	public boolean deleteUserById(int id);   //删除用户
	public boolean deleteUsers(int[] ids);
	public UserPager getUserPager(int index, int pageSize);
}
