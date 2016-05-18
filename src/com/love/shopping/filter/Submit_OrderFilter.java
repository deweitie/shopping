package com.love.shopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Submit_OrderFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Submit_OrderFilter----过滤器的销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Submit_OrderFilter----过滤器的执行");
		request.setAttribute("loginS", "loginS");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Submit_OrderFilter----过滤器的初始化");
	}

}
