package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.SubType;

public interface AdminSubTypeDao {

	public List getSubTypeBySuperTypeId(int superTypeId);
	public boolean addSubType(SubType type);
	public boolean checkSubTypeIsExist(String subTypeName);
}
