package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.SubType;

public interface SubTypeDao {
	//���ݴ����ID��ȡ����С��
	public List<SubType> showAllSubTypeBySuperId(int superId);
}
