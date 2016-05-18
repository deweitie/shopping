package com.love.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.shopping.model.Model;
import com.love.shopping.po.Order;
import com.love.shopping.po.OrderItem;
import com.love.shopping.po.User;
import com.love.shopping.vo.CartItem;

public class AddOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//得到用户提交过来的详细的订单信息
		String recvName = request.getParameter("recvName");//收货人姓名
		String email = request.getParameter("email");
		String mphone = request.getParameter("mphone");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String name=(String)request.getSession().getAttribute("name");
		User user = new User();
		Order order = new Order();
		user.setName(name);
		user.setMphone(mphone);
		user.setPhone(phone);
		user.setAddress(address);
		user.setPostcode(postcode);
		user.setEmail(email);
		order.setUser(user);
		order.setRecvName(recvName);
		Collection<CartItem> ci =(Collection<CartItem>)request.getSession().getAttribute("ci");
		List<OrderItem> item = new ArrayList<OrderItem>();
		Iterator<CartItem> it = ci.iterator();
		while(it.hasNext()){
			CartItem cartItem = (CartItem) it.next();
			OrderItem order_Item = new OrderItem();
			order_Item.setBookId(cartItem.getBook().getBookId());
			order_Item.setBookName(cartItem.getBook().getBookName());
			order_Item.setBookNum(cartItem.getCount());
			order_Item.setPrice(cartItem.getItemPrice());
			item.add(order_Item);
		}
		order.setOrderItem(item);
		Model model = new Model();
		int orderId = model.addOrder(order);
		order.setOrderId(orderId);
		request.setAttribute("order", order);
		request.setAttribute("user", user);
		request.getSession().removeAttribute("ci");
		request.getSession().removeAttribute("cart");
		request.getRequestDispatcher("orderSuccess.jsp").forward(request, response);
		//response.sendRedirect("orderSuccess.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
