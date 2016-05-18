package com.love.shopping.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.love.shopping.model.Model;
import com.love.shopping.po.Book;
import com.love.shopping.po.Inform;

/*一个 web.xml 可以注册多个 servlet 事件监听 器。
 * web 服务器按照它们在 web.xml 中注册顺 序来加载和注册这些 servlet 事件监听器。
 *  servlet 事件监听器的注册和调用过程都是由 web 容器自动完成的，
 *  当发生被监听对象被创 建，修改，销 毁等事件时，
 *  web 容器将调用与之相关的 servlet 事件监听器对象的相应方法 (所监听到的对象如果在创建、 修改、 销毁事件触发的时候就会调用这些监听器这就相当于面 向事件编程的概念)，
 *  用户在这些方法中编写的事件处理代码(相当于 JS 中的事件响应)即被 执行。
 *  */
// ServletContextListener：用于监听 WEB 应用启动和销毁的事件，监听器类需要实现 javax.servlet.ServletContextListener 接口。
// HttpSessionListener：用于监听 Session 对象的创建和销毁，监听器类需要实现 javax.servlet.http.HttpSessionListener 接 口 或 者 javax.servlet.http.HttpSessionActivationListener 接口，或者两个都实现。
//HttpSessionAttributeListener：用于监听 Session 对象属性的改变事件，监听器类需 要实现 javax.servlet.http.HttpSessionAttributeListener 接口
//部署 监听器的部署在 web.xml 文件中配置，在配置文件中，它的位置应该在过滤器的后面 Servlet 的前面 
public class UserLoginListener implements ServletContextListener,
				HttpSessionListener, HttpSessionAttributeListener {
	private List<String> nameList;  //登录的用户的姓名集合（只放姓名）

	private ServletContext context; //服务器环境（上下文）
	
//ServletContextListener的 方法
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("UserLoginListener----contextDestroyed");
		context.removeAttribute("informList");
		context.removeAttribute("hostList");
		context.removeAttribute("newList");
		context.removeAttribute("saleList");
		context.removeAttribute("specialList");
	}

	public void contextInitialized(ServletContextEvent e) {
		nameList = new ArrayList<String>();
		context = e.getServletContext();
		context.setAttribute("nameList", nameList);
		System.out.println("UserLoginListener----contextInitialized");
		
		Model model = new Model();
		List<Book> hostList0 = model.showBooks(1, 1); //1 热卖书籍
		List<Book> newList0 = model.showBooks(2, 1); //2新到书籍
		List<Book> saleList0 = model.showBooks(3, 1);//3打折书籍
		List<Book> specialList0=model.showBooks(4, 1);//4特别推荐
		Book book11 = (Book) hostList0.get(0);
		Book book12 = (Book) hostList0.get(1);	
		Book book2 = (Book) newList0.get(0);
		Book book3 = (Book) specialList0.get(0);
		
		List<Book> hostList = new ArrayList<Book>();
		hostList.add(book11);
		hostList.add(book12);
		List<Book> newList = new ArrayList<Book>();
		newList.add(book2);
		List<Book> specialList = new ArrayList<Book>();
		specialList.add(book3);
		List<Book> saleList = new ArrayList<Book>();
		for(int i=0;i<3;i++){
			Book book = (Book) saleList0.get(i);
			saleList.add(book);
		}
		
		List<Inform> informList = model.getAllInform();
		context.setAttribute("informList", informList);
		context.setAttribute("hostList", hostList);
		context.setAttribute("newList", newList);
		context.setAttribute("saleList", saleList);
		context.setAttribute("specialList", specialList);
	}
//HttpSessionListener的 方法 
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("UserLoginListener----sessionCreated");
		HttpSession session=arg0.getSession();
		String name = (String) session.getAttribute("name");
		System.out.println("UserLoginListener----sessionCreated"+name);
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		nameList=new ArrayList<String>();
		context.setAttribute("nameList", nameList);
//		HttpSession session = hse.getSession();
//		String name = (String) session.getAttribute("name");
		System.out.println("UserLoginListener----sessionDestroyed");
//		if(name != null) {
//			nameList.remove(name);
//			context.setAttribute("nameList", nameList);
//		}
		
	}
//HttpSessionAttributeListener的方法
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		HttpSession session = hsbe.getSession();
		String name = (String) session.getAttribute("name");
		nameList.add(name);
		context.setAttribute("nameList", nameList);
		System.out.println("UserLoginListener----attributeAdded");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("UserLoginListener----attributeRemoved");
		
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("UserLoginListener----attributeReplaced");
		
	}
}
