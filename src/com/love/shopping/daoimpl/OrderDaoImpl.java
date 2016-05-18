package com.love.shopping.daoimpl;

import com.love.shopping.common.DbUtil;
import com.love.shopping.dao.OrderDao;
import com.love.shopping.po.Order;
import com.love.shopping.po.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

	/**
	 * 添加订单，并返回订一个单号
	 * @param order 一个订单
	 * @return int  返回一个整型的订单号
	 */
	public int addOrder(Order order) {
		int orderId = 0;
		PreparedStatement pstmt_order = null; //用于对订单进行操作的预定义语句
		PreparedStatement pstmt_item = null; //用于对订单项进行操作的预定义语句
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql_order = "insert into tb_order values(null,?,?,?,?,?,null,?)";
		try {
			//事物处理
			dbUtil = new DbUtil();
			dbUtil.getCon().setAutoCommit(false);
			//将订单中的数据录入数据库
			pstmt_order = dbUtil.getCon().prepareStatement(sql_order);
			pstmt_order.setString(1, order.getUser().getName());
			pstmt_order.setString(2, order.getRecvName());
			pstmt_order.setString(3, order.getUser().getAddress());
			pstmt_order.setString(4, order.getUser().getPostcode());
			pstmt_order.setString(5, order.getUser().getEmail());
			pstmt_order.setInt(6,order.getFlag() );
			pstmt_order.executeUpdate();
			rs = pstmt_order.getGeneratedKeys();//取得主键,获取由于执行此 Statement 对象而创建的所有自动生成的键。如果此 Statement 对象没有生成任何键，则返回空的 ResultSet 对象。 
			rs.next();
			orderId = rs.getInt(1); //返回一个订单号
			//将订单项中的数据录入数据库
			String sql_item = "insert into tb_orderItem values(null,?,?,?,?,?)";
			pstmt_item = dbUtil.getCon().prepareStatement(sql_item);
			List<OrderItem> orderItem = order.getOrderItem();//得到所有订单项
			for(int i=0;i<orderItem.size();i++) {
				OrderItem orderItems = (OrderItem)orderItem.get(i);
				pstmt_item.setInt(1, orderId);
				pstmt_item.setInt(2, orderItems.getBookId());
				pstmt_item.setString(3, orderItems.getBookName());
				pstmt_item.setFloat(4, orderItems.getPrice());
				pstmt_item.setInt(5, orderItems.getBookNum());
				pstmt_item.addBatch();
			}
			pstmt_item.executeBatch();
			dbUtil.getCon().commit();
			dbUtil.getCon().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbUtil.getCon().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				rs.close();
				pstmt_order.close();
				pstmt_item.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return orderId;
	}
	//根据当前用户的用户名查订单
	public List<Order> selectOrder(String name) {
		List<Order> list = new ArrayList<Order>();
		Order or = null ;
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select * from tb_order where name=?";	
		 try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, name);
			rs =pre.executeQuery();
			  while(rs.next()){
				  
				  or = new Order ();
				  //User user = new User();
				  or.setOrderId(rs.getInt("orderId"));
					//user.setName(re.getString("name"));
				  or.setRecvName(rs.getString("realName"));
				  or.setAddress(rs.getString("address"));
				  or.setPostcode(rs.getString("postcode"));
				  or.setEmail(rs.getString("email"));
					//user.setAddress(re.getString("address"));
					//user.setPostcode(re.getString("postcode"));
					//user.setEmail(re.getString("email"));
					//or.setUser(user);
				  or.setOrderDate(rs.getString("orderDate"));
				  or.setFlag(rs.getInt("flag"));
				  list.add(or);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 根据订单号查订单项
	public List<OrderItem> selectOrderItem(int id ) {
		List<OrderItem> list = new ArrayList<OrderItem>();
		OrderItem ordetrItem = null ;
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		ResultSet re = null;
		String sql = "select * from tb_orderItem where orderId = ? ";
		try{
		pre = dao.getCon().prepareStatement(sql);
		pre.setInt(1, id);
		re =pre.executeQuery();
		  while(re.next()){
			  ordetrItem = new OrderItem();
			  ordetrItem.setBookId(re.getInt("bookId"));
			  ordetrItem.setBookName(re.getString("bookName"));
			  ordetrItem.setBookNum(re.getInt("bookNum"));
			  ordetrItem.setOrderId(re.getInt("orderId"));
			  ordetrItem.setOrderItemId(re.getInt("orderItemId"));
			  ordetrItem.setPrice(re.getFloat("price"));
			  list.add(ordetrItem);
		  }
		}catch (Exception e) {
		}
		return list;
	}
}
