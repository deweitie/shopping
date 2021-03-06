package com.love.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.shopping.vo.Cart;

public class DeleteItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = 0;
		String str_bookId = request.getParameter("bookId");
		if(str_bookId != null){
			bookId = Integer.parseInt(str_bookId);
		}
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		cart.deleteItem(bookId);
		response.sendRedirect("buyBooksServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
