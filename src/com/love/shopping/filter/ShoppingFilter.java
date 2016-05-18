package com.love.shopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ShoppingFilter implements Filter {

	//过滤器的初始化
	public void init(FilterConfig config) throws ServletException {
		System.out.println("ShoppingFilter----过滤器的初始化");
	}
	//执行过滤器
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("ShoppingFilter----过滤器的执行");
		//乱码处理
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
		
	}
	//过滤器的销毁
	public void destroy() {
		System.out.println("ShoppingFilter----过滤器的销毁");
	}



}
