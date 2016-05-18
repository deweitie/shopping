package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.Inform;
import com.love.shopping.po.InformPager;


public interface AdminInformDao {

	public boolean addInform(Inform inform);
	public List<Inform> getAllInform();
	public boolean deleteInform(int[] ids);
	public Inform getOneInform(int id);
	public InformPager getInformPager(int index,int pageSize);
}
