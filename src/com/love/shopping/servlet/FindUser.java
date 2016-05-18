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

import com.love.shopping.common.DbUtil;
import com.love.shopping.po.User;

public class FindUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {//设置输出内容和编码格式
             String name=request.getParameter("name");
             PreparedStatement stat=null;
             DbUtil db=new DbUtil();
             ResultSet set=null;
             String sql="select * from tb_user where name=?";
             try {
				stat=db.getCon().prepareStatement(sql);
				stat.setString(1, name);
				set=stat.executeQuery();
		
				if(set.next()){
				  //User user=new User();
				  //user.setName(name);
				  //user.setQuestion(set.getString("question"));
				  //user.setAnswer(set.getString("answer"));
				  //request.getSession().setAttribute("user", user);
				  //response.sendRedirect("findAnswer.jsp");
				  request.setAttribute("uesername", name);
				  request.setAttribute("question", set.getString("question"));
				  request.setAttribute("answer", set.getString("answer"));
				  
				  request.getRequestDispatcher("findAnswer.jsp").forward(request, response);
				}
				else{
					request.setAttribute("errorname", "用户名不存在！！");
					request.getRequestDispatcher("PwdIndex.jsp").forward(request, response);
				}
			}catch (Exception e){
				e.printStackTrace();
			}        
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	       this.doGet(request, response);
	}
}
