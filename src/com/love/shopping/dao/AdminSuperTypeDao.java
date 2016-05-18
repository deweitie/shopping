package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.SuperType;

public interface AdminSuperTypeDao {

	public boolean addSuperType(SuperType type);
	public List getSuperType();
	public boolean checkSuperTypeIsExist(String superTypeName);
}
