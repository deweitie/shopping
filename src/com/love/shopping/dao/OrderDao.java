package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.Order;
import com.love.shopping.po.OrderItem;


/**
 * �Զ������в����Ľӿ� 
 */
public interface OrderDao {
	
	//��Ӷ����������ض�һ������
	public int addOrder(Order order);
	//���ݵ�ǰ�û����û����鶩��
	public List<Order> selectOrder(String name);
	//�鶩����
	public List<OrderItem> selectOrderItem(int id);
}
