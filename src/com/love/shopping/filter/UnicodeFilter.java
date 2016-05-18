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

//对/*，web根目录下所有信息过滤
//若有多个 Filter 程序对某个 Servlet 程序的访问过程进行拦截，
//当针对该 Servlet 的访问请求到达时，web 容器将把这多个 Filter 程序组合成一个 Filter 链(过滤器链)。
//Filter 链中各个 Filter 的拦截顺序与它们在应用程序的 web.xml 中映射的顺序一致


public class UnicodeFilter implements Filter {

	/*在Web容器卸载 Filter 对象之前被调用。
	 *该方法在Filter的生命周期中仅执行一次。在这个方法中，可以释放过滤器使用的资源。
    */
	public void destroy() {
		System.out.println("UnicodeFilter----过滤器的销毁");
	}
 /*doFilter()方法类似于Servlet接口的service()方法。
  * 当客户端请求目标资源的时候，容器就会调用与这个目标资源相关联的过滤器的 doFilter()方法。
  * 其中参数 request, response 为 web 容器或 Filter 链的上一个 Filter 传递过来的请求和相应对象；
  * 参数 chain 为代表当前 Filter 链的对象，在特定的操作完成后，
  * 可以在当前 Filter 对象的 doFilter 方法内部需要调用 FilterChain 对象的 chain.doFilter(request,response)方法
  * 才能把请求交付给 Filter 链中的下一个 Filter 或者目标 Servlet 程序去处理，
  * 也可以直接向客户端返回响应信息，或者利用RequestDispatcher的forward()和include()方法，
  * 以及 HttpServletResponse的sendRedirect()方法将请求转向到其他资源。
  * 这个方法的请求和响应参数的类型是 ServletRequest和ServletResponse，
  * 也就是说，过滤器的使用并不依赖于具体的协议.
  * */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("UnicodeFilter----过滤器的执行");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest httpreq = (HttpServletRequest)request;
		HttpServletResponse httpresp = (HttpServletResponse)response;
		//httpreq.getSession().setMaxInactiveInterval(5);
		chain.doFilter(httpreq, httpresp);
	}
	
/*在 web 应用程序启动时，web 服务器将根据 web.xml 文件中的配置信息来创建每个注册的 Filter 实例对象，并将其保存在服务器的内存中。
 * Web容器创建 Filter 对象实例后，将立即调用该 Filter 对象的 init 方法。
 * Init 方法在 Filter 生命周期中仅执行一次，web 容器在调用 init 方法时，
 * 会传递一个包含 Filter 的配置和运行环境的 FilterConfig 对象(FilterConfig的用法和ServletConfig类似)。
 * 利用FilterConfig对象可以得到ServletContext对象，以及部署描述符中配置的过滤器的初始化参数。
 * 在这个方法中，可以抛出ServletException异常，通知容器该过滤器不能正常工作。
*/
	public void init(FilterConfig config) throws ServletException {
		System.out.println("UnicodeFilter----过滤器的初始化,对/*，web根目录下所有信息过滤");
	}

}
