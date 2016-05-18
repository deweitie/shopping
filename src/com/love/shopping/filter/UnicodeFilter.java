package com.love.shopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��/*��web��Ŀ¼��������Ϣ����
//���ж�� Filter �����ĳ�� Servlet ����ķ��ʹ��̽������أ�
//����Ը� Servlet �ķ������󵽴�ʱ��web ������������ Filter ������ϳ�һ�� Filter ��(��������)��
//Filter ���и��� Filter ������˳����������Ӧ�ó���� web.xml ��ӳ���˳��һ��


public class UnicodeFilter implements Filter {

	/*��Web����ж�� Filter ����֮ǰ�����á�
	 *�÷�����Filter�����������н�ִ��һ�Ρ�����������У������ͷŹ�����ʹ�õ���Դ��
    */
	public void destroy() {
		System.out.println("UnicodeFilter----������������");
	}
 /*doFilter()����������Servlet�ӿڵ�service()������
  * ���ͻ�������Ŀ����Դ��ʱ�������ͻ���������Ŀ����Դ������Ĺ������� doFilter()������
  * ���в��� request, response Ϊ web ������ Filter ������һ�� Filter ���ݹ������������Ӧ����
  * ���� chain Ϊ����ǰ Filter ���Ķ������ض��Ĳ�����ɺ�
  * �����ڵ�ǰ Filter ����� doFilter �����ڲ���Ҫ���� FilterChain ����� chain.doFilter(request,response)����
  * ���ܰ����󽻸��� Filter ���е���һ�� Filter ����Ŀ�� Servlet ����ȥ����
  * Ҳ����ֱ����ͻ��˷�����Ӧ��Ϣ����������RequestDispatcher��forward()��include()������
  * �Լ� HttpServletResponse��sendRedirect()����������ת��������Դ��
  * ����������������Ӧ������������ ServletRequest��ServletResponse��
  * Ҳ����˵����������ʹ�ò��������ھ����Э��.
  * */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("UnicodeFilter----��������ִ��");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest httpreq = (HttpServletRequest)request;
		HttpServletResponse httpresp = (HttpServletResponse)response;
		//httpreq.getSession().setMaxInactiveInterval(5);
		chain.doFilter(httpreq, httpresp);
	}
	
/*�� web Ӧ�ó�������ʱ��web ������������ web.xml �ļ��е�������Ϣ������ÿ��ע��� Filter ʵ�����󣬲����䱣���ڷ��������ڴ��С�
 * Web�������� Filter ����ʵ���󣬽��������ø� Filter ����� init ������
 * Init ������ Filter ���������н�ִ��һ�Σ�web �����ڵ��� init ����ʱ��
 * �ᴫ��һ������ Filter �����ú����л����� FilterConfig ����(FilterConfig���÷���ServletConfig����)��
 * ����FilterConfig������Եõ�ServletContext�����Լ����������������õĹ������ĳ�ʼ��������
 * ����������У������׳�ServletException�쳣��֪ͨ�����ù�������������������
*/
	public void init(FilterConfig config) throws ServletException {
		System.out.println("UnicodeFilter----�������ĳ�ʼ��,��/*��web��Ŀ¼��������Ϣ����");
	}

}
