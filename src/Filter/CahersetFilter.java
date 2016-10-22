package Filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CahersetFilter implements Filter {
	
	private FilterConfig fConfig = null;

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding(fConfig.getInitParameter("charset"));
		response.setCharacterEncoding(fConfig.getInitParameter("charset"));
		response.setContentType("text/html;charset=" + fConfig.getInitParameter("charset"));
		chain.doFilter((ServletRequest) Proxy.newProxyInstance(CahersetFilter.class.getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				if(method.getName().equals("getParameter")){
					
					Object value = method.invoke(request, args);
					if(value == null)return null;
					if(request.getMethod().equalsIgnoreCase("get")){
						
						String msg = (String) method.invoke(request, args);
						msg = new String(msg.getBytes("ISO8859-1"), request.getCharacterEncoding());
						return msg;
					}return value;
					
				}else{
					return method.invoke(request, args);
				}
			}
		}), response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
		this.fConfig = fConfig;
	}
	
	
	public void destroy() {

	}

}
