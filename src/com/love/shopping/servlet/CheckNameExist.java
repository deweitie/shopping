package com.love.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.shopping.model.Model;


public class CheckNameExist extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��������
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		//request.getSession().setAttribute("name",name);
		System.out.println(name);
		Model model = new Model();
		if(model.checkNameExist(name)){//�û����Ѵ���
			out.print("<Users>");
			out.print("<user>");
			out.print("<name>"+"exist"+"</name>");
			out.print("</user>");
			out.print("</Users>");
		}else{//����ע��
			out.print("<Users>");
			out.print("<user>");
			out.print("<name>"+"notExist"+"</name>");
			out.print("</user>");
			out.print("</Users>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}