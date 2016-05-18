package com.love.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.shopping.model.Model;
import com.love.shopping.po.User;

public class FindAnswer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String answer1=request.getParameter("answer");
		String answer=new String(answer1.getBytes("ISO-8859-1"),"UTF-8");
		String username=request.getParameter("uesername");
	    //String username= (String)request.getSession().getAttribute("name");
	   
	    Model modelUser=new Model();
	    User user=modelUser.getUser(username);
	   
	    String Answer=user.getAnswer();
       
	   System.out.println(Answer+"==="+answer);
       if(Answer.equals(answer))
       {
    	   request.setAttribute("username",username);
    	   request.getRequestDispatcher("updataPwd.jsp").forward(request, response);
       }
       else
       {
    	 response.sendRedirect("answerFail.jsp"); 
       }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doGet(request, response);
	}

}
