package com.love.shopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ShoppingFilter implements Filter {

	//�������ĳ�ʼ��
	public void init(FilterConfig config) throws ServletException {
		System.out.println("ShoppingFilter----�������ĳ�ʼ��");
	}
	//ִ�й�����
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("ShoppingFilter----��������ִ��");
		//���봦��
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
		
	}
	//������������
	public void destroy() {
		System.out.println("ShoppingFilter----������������");
	}



}
