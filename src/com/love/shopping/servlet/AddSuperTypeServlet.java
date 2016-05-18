package com.love.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.shopping.model.Model;
import com.love.shopping.po.SuperType;

public class AddSuperTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//String superTypeName1 = request.getParameter("superTypeName");
		//解决乱码,用Post方法了  不用了
		//byte[] buf = superTypeName1.getBytes("iso-8859-1");
		//String superTypeName=new String(buf);
		
		//String superTypeName=new String(superTypeName1.getBytes("ISO-8859-1"),"UTF-8");
		
		//String superTypeName=new String(request.getParameter("superTypeName").getBytes("ISO-8859-1"),"UTF-8");
		String superTypeName = request.getParameter("superTypeName");


		System.out.println(superTypeName);
		if(superTypeName != null) {
			
			Model model = new Model();
			SuperType superType = new SuperType();
			superType.setTypeName(superTypeName);
			if(model.addSuperType(superType)) {
				request.setAttribute("message", "添加成功");
			} else {
				request.setAttribute("message", "添加失败");
			}
			request.getRequestDispatcher("Admin/pages/addSuperType.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
