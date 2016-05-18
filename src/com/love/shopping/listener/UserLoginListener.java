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

/*һ�� web.xml ����ע���� servlet �¼����� ����
 * web ���������������� web.xml ��ע��˳ �������غ�ע����Щ servlet �¼���������
 *  servlet �¼���������ע��͵��ù��̶����� web �����Զ���ɵģ�
 *  ���������������󱻴� �����޸ģ��� �ٵ��¼�ʱ��
 *  web ������������֮��ص� servlet �¼��������������Ӧ���� (���������Ķ�������ڴ����� �޸ġ� �����¼�������ʱ��ͻ������Щ����������൱���� ���¼���̵ĸ���)��
 *  �û�����Щ�����б�д���¼��������(�൱�� JS �е��¼���Ӧ)���� ִ�С�
 *  */
// ServletContextListener�����ڼ��� WEB Ӧ�����������ٵ��¼�������������Ҫʵ�� javax.servlet.ServletContextListener �ӿڡ�
// HttpSessionListener�����ڼ��� Session ����Ĵ��������٣�����������Ҫʵ�� javax.servlet.http.HttpSessionListener �� �� �� �� javax.servlet.http.HttpSessionActivationListener �ӿڣ�����������ʵ�֡�
//HttpSessionAttributeListener�����ڼ��� Session �������Եĸı��¼������������� Ҫʵ�� javax.servlet.http.HttpSessionAttributeListener �ӿ�
//���� �������Ĳ����� web.xml �ļ������ã��������ļ��У�����λ��Ӧ���ڹ������ĺ��� Servlet ��ǰ�� 
public class UserLoginListener implements ServletContextListener,
				HttpSessionListener, HttpSessionAttributeListener {
	private List<String> nameList;  //��¼���û����������ϣ�ֻ��������

	private ServletContext context; //�����������������ģ�
	
//ServletContextListener�� ����
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
		List<Book> hostList0 = model.showBooks(1, 1); //1 �����鼮
		List<Book> newList0 = model.showBooks(2, 1); //2�µ��鼮
		List<Book> saleList0 = model.showBooks(3, 1);//3�����鼮
		List<Book> specialList0=model.showBooks(4, 1);//4�ر��Ƽ�
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
//HttpSessionListener�� ���� 
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
//HttpSessionAttributeListener�ķ���
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
