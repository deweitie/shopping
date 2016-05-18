package com.love.shopping.filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.love.shopping.wrapper.HttpReqWrapper;

//ֻ��/checkLogin_Note�����Servlet������Ϣ

public class WordsFilter implements Filter {
	
	private Map<String, String>map = new HashMap<String, String>();
	//�������ĳ�ʼ��
	public void init(FilterConfig config) throws ServletException {
		System.out.println("WordsFilter----�������ĳ�ʼ��,ֻ��/checkLogin_Note�����Servlet������Ϣ");
		String filePath = config.getInitParameter("filePath");//�������ļ���ȡ���ļ������·��
		ServletContext context = config.getServletContext();
		String realPath = context.getRealPath(filePath);//�������·��ȡ�þ���·��
		try {
			FileReader freader = new FileReader(realPath);//���ݾ���·����ͨ���ļ�������ȡ�ļ�
			BufferedReader br = new BufferedReader(freader);
			String line = null;
			while((line=br.readLine()) != null) {
				String []str = line.split("=");
				map.put(str[0], str[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("WordsFilter----��������ִ��");
		//���봦��
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		HttpServletRequest HttpReq = (HttpServletRequest) request;
		HttpReqWrapper hrw = new HttpReqWrapper(HttpReq);
		hrw.setMap(map);
		//���ݸ�Ŀ��servlet��jsp��ʵ����ʱ��װ����������ã�������ԭʼ��HttpServletRequest����
		chain.doFilter(hrw, response);
//		PrintWriter out = response.getWriter();
//		//��ȡ�ͻ����ύ������
//		String content = request.getParameter("content");
//		if (content != null) {
//			String contents = changeWords(content);
//			out.print(contents);
//			//chain.doFilter(request, response);
//		}else {
//			chain.doFilter(request, response);
//		}
	}

	public void destroy() {
		System.out.println("WordsFilter--������������--");
	}
	
	//�����໰
//	public String changeWords(String content) {
//		StringBuffer sb = new StringBuffer(content);
//		Set keys = map.keySet();
//		Iterator<String>it = keys.iterator();
//		while(it.hasNext()) {
//			String key = it.next();
//			int index = sb.indexOf(key);
//			if(index != -1) {
//				sb.replace(index, index+key.length(), map.get(key));
//			}
//		}
//		return sb.toString();
//	}

}
