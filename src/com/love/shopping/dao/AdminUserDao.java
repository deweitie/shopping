package com.love.shopping.dao;

import java.util.List;
import java.util.Map;

import com.love.shopping.po.UserPager;


public interface AdminUserDao {

	public Map getAllUsers();   //��ʾ�û�
	public boolean deleteUserById(int id);   //ɾ���û�
	public boolean deleteUsers(int[] ids);
	public UserPager getUserPager(int index, int pageSize);
}
