package com.love.shopping.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.love.shopping.model.Model;
import com.love.shopping.po.Book;

public class AddBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//新建一个SmartUpload对象
		   SmartUpload su = new SmartUpload(); 
		   //上传初始化
		   su.initialize(getServletConfig(),request, response);
		    //限制每个上传文件的最大长度。
		    su.setMaxFileSize(100000); 
		    //限制总上传数据的长度。
		    su.setTotalMaxFileSize(200000); 
		    //设定允许上传的文件（通过扩展名限制）,仅允许doc,txt文件。
		    su.setAllowedFilesList("docx,txt,jpg");
		   //设定禁止上传的文件（通过扩展名限制）,禁止上传带有exe,bat,
		   //jsp,htm,html扩展名的文件和没有扩展名的文件。   
				try {
					su.setDeniedFilesList("exe,bat,jsp,htm,html,,");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			System.out.println("1个文件上传成功");
			//上传文件	
				try {
					su.upload();
				} catch (SmartUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("个文件上传成功");
			
			//将上传文件全部保存到指定目录  
			try {
				int count = su.save("/upload");
				System.out.println(count+"个文件上传成功");
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   //逐一提取上传信息
	    String pic = null;
		for(int i=0;i<su.getFiles().getCount();i++)
		{ 
		  com.jspsmart.upload.File file=su.getFiles().getFile(i);
		  if(file.isMissing())continue;
		  System.out.println("<table border=1>");
		  System.out.println("<tr><td>表单项名(fieldname)</td><td>"+file.getFieldName()+"</td></tr>");
		  System.out.println("<tr><td>文件长度(size)</td><td>"+file.getSize()+"</td></tr>");
		  System.out.println("<tr><td>文件名(fieldname)</td><td>"+file.getFileName()+"</td></tr>");
		  System.out.println("<tr><td>文件扩展名(FILEext)</td><td>"+file.getFileExt()+"</td></tr>");
		  System.out.println("<tr><td>文件全名(fieldname)</td><td>"+file.getFilePathName()+"</td></tr>");
		  System.out.println("</table><br>");
		  System.out.println("<hr>");
		  pic=file.getFileName();  
		}
		String pic1="upload/"+pic;
		
		String str_superTypeId = su.getRequest().getParameter("superTypeId");
		String str_subTypeId = su.getRequest().getParameter("subTypeId");
		String bookName = su.getRequest().getParameter("bookName");             //
		String ISBN = su.getRequest().getParameter("ISBN");                     //
		String introduce = su.getRequest().getParameter("introduce");             //
		String pages_str = su.getRequest().getParameter("pages"); 
		String publisher = su.getRequest().getParameter("publisher");              //
		String author = su.getRequest().getParameter("author");                   //
		String str_price = su.getRequest().getParameter("price");
		String str_nowPrice = su.getRequest().getParameter("nowPrice");
		//String picture = request.getParameter("picture");                 //
		String str_booksNum = su.getRequest().getParameter("booksNum");        
		String str_newBooks = su.getRequest().getParameter("newBooks");      
		String str_saleBooks = su.getRequest().getParameter("saleBooks");
		String str_hostBooks = su.getRequest().getParameter("hostBooks");
		String str_specialBooks = su.getRequest().getParameter("specialBooks");
		//byte[] bookName_buf = bookName.getBytes("iso8859-1");
		//byte[] ISBN_buf = ISBN.getBytes("iso8859-1");
		//byte[] introduce_buf = introduce.getBytes("iso8859-1");
		//byte[] publisher_buf = publisher.getBytes("iso8859-1");
		//byte[] author_buf = author.getBytes("iso8859-1");
		//byte[] picture_buf = picture.getBytes("iso8859-1");
		int superTypeId = Integer.parseInt(str_superTypeId);
		int subTypeId = Integer.parseInt(str_subTypeId);
		float price = Float.parseFloat(str_price);
		float nowPrice = Float.parseFloat(str_nowPrice);
		int booksNum = Integer.parseInt(str_booksNum);
		int newBooks = 0;
		int saleBooks = 0;
		int hostBooks = 0;
		int specialBooks = 0;
		int pages = 0;
		if(str_newBooks != null)
			newBooks = Integer.parseInt(str_newBooks);
		if(str_saleBooks != null)
			saleBooks = Integer.parseInt(str_saleBooks);
		if(str_hostBooks != null)
			hostBooks = Integer.parseInt(str_hostBooks);
		if(str_specialBooks != null)
			specialBooks = Integer.parseInt(str_specialBooks);
		if(pages_str != null) {
			pages = Integer.parseInt(pages_str);
		}
		Model model = new Model();
		Book book = new Book();
		book.setSuperTypeId(superTypeId);
		book.setSubTypeId(subTypeId);
		book.setBookName(bookName);
		book.setISBN(ISBN);
		book.setIntroduce(introduce);
		book.setPages(pages);
		book.setPublisher(publisher);
		book.setAuthor(author);
		book.setPrice(price);
		book.setNowPrice(nowPrice);
		book.setPicture(pic1);
		//book.setPicture(new String(picture_buf));
		book.setNewBooks(newBooks);
		book.setSaleBooks(saleBooks);
		book.setHostBooks(hostBooks);
		book.setSpecialBooks(specialBooks);
		book.setBookNum(booksNum);
		if(model.addBook(book)) {
			request.setAttribute("message", "添加成功");
		} else {
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("Admin/pages/addBooks.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
