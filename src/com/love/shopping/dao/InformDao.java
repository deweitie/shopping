package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.Inform;


public interface InformDao {
	//����ʱ������ʾ��Ӧ�Ĺ���
	public List<Inform> showInformByInTime();
	//���ݹ����ID�õ��ù�����Ϣ
	public Inform getInformById(int infromId);
}
