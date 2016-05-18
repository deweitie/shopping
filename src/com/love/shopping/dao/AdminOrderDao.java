package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.Order;
import com.love.shopping.po.OrderFreezePager;
import com.love.shopping.po.OrderNotSendPager;
import com.love.shopping.po.OrderPager;
import com.love.shopping.po.OrderSendPager;



public interface AdminOrderDao {

	public List getAllOrder();
	public Order getOneOrder(int id);
	public List getNotSendOrder(int flag);
	public List getSendOrder(int flag);
	public boolean SendOrder(int[] orderids);
	public OrderPager getOrderPager(int index, int pageSize);
	public OrderSendPager getOrderSendPager(int index,int pageSize);
	public boolean deleteOrder(int[] ids);
	public OrderNotSendPager getOrderNotSendPager(int index,int pageSize);
	public OrderFreezePager getOrderFreezePager(int index,int pageSize);
	public boolean freezeOrder(int[] orderids);
}
