package com.love.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.shopping.model.Model;

public class AdminSendOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orders_str = request.getParameter("orderIds");
		//��õ�ǰҳ��
		String pageOffset_str = request.getParameter("pageOffset");
		String pageSize_str = request.getParameter("pageSize");
		int pageOffset = 0;
		int pageSize = 5;
		if(pageOffset_str != null && pageSize_str != null) {
			pageOffset = Integer.parseInt(pageOffset_str);
			pageSize = Integer.parseInt(pageSize_str);
		}
		String[] ids_str = null;
		if(orders_str != "") {
			ids_str = orders_str.split(",");
		}
		int[] orderids = new int[ids_str.length];
		for(int i=0;i<ids_str.length;i++) {
			orderids[i] = Integer.parseInt(ids_str[i]);
		}
		Model model = new Model();
		if(model.SendOrder(orderids)) {
			request.getRequestDispatcher("getOrderNotSendPagerServlet?pager.offset="+pageOffset+"&pageSize="+pageSize).forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
