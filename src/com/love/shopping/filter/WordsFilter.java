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

//只对/checkLogin_Note，这个Servlet过滤信息

public class WordsFilter implements Filter {
	
	private Map<String, String>map = new HashMap<String, String>();
	//过滤器的初始化
	public void init(FilterConfig config) throws ServletException {
		System.out.println("WordsFilter----过滤器的初始化,只对/checkLogin_Note，这个Servlet过滤信息");
		String filePath = config.getInitParameter("filePath");//从配置文件中取得文件的相对路径
		ServletContext context = config.getServletContext();
		String realPath = context.getRealPath(filePath);//根据相对路径取得绝对路径
		try {
			FileReader freader = new FileReader(realPath);//根据绝对路径，通过文件流来读取文件
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
		System.out.println("WordsFilter----过滤器的执行");
		//乱码处理
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		HttpServletRequest HttpReq = (HttpServletRequest) request;
		HttpReqWrapper hrw = new HttpReqWrapper(HttpReq);
		hrw.setMap(map);
		//传递给目标servlet或jsp的实际上时包装器对象的引用，而不是原始的HttpServletRequest对象
		chain.doFilter(hrw, response);
//		PrintWriter out = response.getWriter();
//		//获取客户端提交的数据
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
		System.out.println("WordsFilter--过滤器的销毁--");
	}
	
	//屏蔽脏话
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
