package com.love.shopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.shopping.po.Admin;

//ֻ��/Admin/pages/*·���µ��������

public class AdminLoginFilter implements Filter {

	public void destroy() {
		System.out.println("AdminLoginFilter----������������");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("AdminLoginFilter----��������ִ��");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest httpreq = (HttpServletRequest)request;
		HttpServletResponse httpresp = (HttpServletResponse)response;
		Admin admin = (Admin) httpreq.getSession().getAttribute("admin");
		if(admin == null) {
			System.out.println("ssssssssssssssss");
			httpreq.getRequestDispatcher("adminLoginError.jsp").forward(httpreq, httpresp);
		} else {
			chain.doFilter(httpreq, httpresp);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("AdminLoginFilter----�������ĳ�ʼ����ֻ��/Admin/pages/*·���µ��������");
	}

}
