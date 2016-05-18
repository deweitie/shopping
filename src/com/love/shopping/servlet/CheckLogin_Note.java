package com.love.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.shopping.po.User;

public class CheckLogin_Note extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���봦��
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//User user = (User)request.getSession().getAttribute("user");
		String username = (String)request.getSession().getAttribute("name");
		if(username!= null){
			//�Ѿ���¼������������
			String title = request.getParameter("ly_title");
			String content=request.getParameter("ly_content");
			String pic=request.getParameter("pic");
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("author", username);
			request.setAttribute("pic", pic);
			request.getRequestDispatcher("addNoteServlet").forward(request, response);
		}else {
			//��û�е�¼����ת����¼ҳ��
			String message = "���ȵ�¼�������ԣ���";
			request.setAttribute("message", message);
			request.getRequestDispatcher("note.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
