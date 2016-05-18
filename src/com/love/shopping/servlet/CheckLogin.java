package com.love.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.shopping.daoimpl.UnLoginException;
import com.love.shopping.model.Model;
import com.love.shopping.po.User;

public class CheckLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = (String)request.getSession().getAttribute("name");
		if(username!= null){
			//已经登录，可以下订单了
			Model model=new Model();
			User user=model.getUser(username);
			request.setAttribute("user", user);
			request.getRequestDispatcher("submit_order.jsp").forward(request, response);
		}else {
			//还没有登录，跳转到登录页面
			String message = "请先登录，再下订单！！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			//response.sendRedirect("login.jsp");
		}
		/*
		User user = (User)request.getSession().getAttribute("user");
		if(user!= null){
			//已经登录，可以下订单了
			response.sendRedirect("submit_order.jsp");
		}else {
			//还没有登录，跳转到登录页面
			String message = "请先登录，再下订单！！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			//response.sendRedirect("login.jsp");
		}
		*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
