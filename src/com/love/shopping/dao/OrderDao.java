package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.Order;
import com.love.shopping.po.OrderItem;


/**
 * 对订单进行操作的接口 
 */
public interface OrderDao {
	
	//添加订单，并返回订一个单号
	public int addOrder(Order order);
	//根据当前用户的用户名查订单
	public List<Order> selectOrder(String name);
	//查订单项
	public List<OrderItem> selectOrderItem(int id);
}
