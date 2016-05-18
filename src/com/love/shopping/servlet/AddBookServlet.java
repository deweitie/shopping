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
		
		//�½�һ��SmartUpload����
		   SmartUpload su = new SmartUpload(); 
		   //�ϴ���ʼ��
		   su.initialize(getServletConfig(),request, response);
		    //����ÿ���ϴ��ļ�����󳤶ȡ�
		    su.setMaxFileSize(100000); 
		    //�������ϴ����ݵĳ��ȡ�
		    su.setTotalMaxFileSize(200000); 
		    //�趨�����ϴ����ļ���ͨ����չ�����ƣ�,������doc,txt�ļ���
		    su.setAllowedFilesList("docx,txt,jpg");
		   //�趨��ֹ�ϴ����ļ���ͨ����չ�����ƣ�,��ֹ�ϴ�����exe,bat,
		   //jsp,htm,html��չ�����ļ���û����չ�����ļ���   
				try {
					su.setDeniedFilesList("exe,bat,jsp,htm,html,,");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			System.out.println("1���ļ��ϴ��ɹ�");
			//�ϴ��ļ�	
				try {
					su.upload();
				} catch (SmartUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("���ļ��ϴ��ɹ�");
			
			//���ϴ��ļ�ȫ�����浽ָ��Ŀ¼  
			try {
				int count = su.save("/upload");
				System.out.println(count+"���ļ��ϴ��ɹ�");
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   //��һ��ȡ�ϴ���Ϣ
	    String pic = null;
		for(int i=0;i<su.getFiles().getCount();i++)
		{ 
		  com.jspsmart.upload.File file=su.getFiles().getFile(i);
		  if(file.isMissing())continue;
		  System.out.println("<table border=1>");
		  System.out.println("<tr><td>������(fieldname)</td><td>"+file.getFieldName()+"</td></tr>");
		  System.out.println("<tr><td>�ļ�����(size)</td><td>"+file.getSize()+"</td></tr>");
		  System.out.println("<tr><td>�ļ���(fieldname)</td><td>"+file.getFileName()+"</td></tr>");
		  System.out.println("<tr><td>�ļ���չ��(FILEext)</td><td>"+file.getFileExt()+"</td></tr>");
		  System.out.println("<tr><td>�ļ�ȫ��(fieldname)</td><td>"+file.getFilePathName()+"</td></tr>");
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
			request.setAttribute("message", "��ӳɹ�");
		} else {
			request.setAttribute("message", "���ʧ��");
		}
		request.getRequestDispatcher("Admin/pages/addBooks.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
