package com.love.shopping.model;

import java.util.List;

import com.love.shopping.dao.OrderDao;
import com.love.shopping.daoimpl.OrderDaoImpl;
import com.love.shopping.po.Order;
import com.love.shopping.po.OrderItem;


public class ModelOrder {
	private OrderDao ordao = new OrderDaoImpl();

	public List<Order> selectOr(String name) {
		List<Order> list =(List<Order>)ordao.selectOrder(name);
		return list;
	}
    public List<OrderItem> selectOrderIt(int id ){
    	List<OrderItem> list = (List<OrderItem>)ordao.selectOrderItem(id);
		return list;
    }
}
