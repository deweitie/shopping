package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.SubType;

public interface SubTypeDao {
	//根据大类的ID获取所有小类
	public List<SubType> showAllSubTypeBySuperId(int superId);
}
