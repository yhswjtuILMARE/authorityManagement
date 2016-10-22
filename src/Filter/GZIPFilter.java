package Filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GZIPFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter print = new PrintWriter(new OutputStreamWriter(buffer, response.getCharacterEncoding()));;
		chain.doFilter(request, (ServletResponse) Proxy.newProxyInstance(GZIPFilter.class.getClassLoader(), response.getClass().getInterfaces(),new InvocationHandler() {
			
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				if(method.getName().equals("getOutputStream")){
					
					return new MyServletOutputStream(buffer);
					
				}else if(method.getName().equals("getWriter")){
					return print; 
				}else{
					return method.invoke(response, args);
				}
			}
		}));
		
		print.close();
		buffer.close();
		byte[] result = buffer.toByteArray();
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(result);
		gout.close();
		
		byte[] gzip = bout.toByteArray();
		
		response.setHeader("content-encoding", "gzip");
		response.setContentLength(gzip.length);
		response.getOutputStream().write(gzip);
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}


class MyServletOutputStream extends ServletOutputStream{

	private ByteArrayOutputStream buffer = null;
	
	public MyServletOutputStream(ByteArrayOutputStream buffer) {
		super();
		this.buffer = buffer;
	}

	public void write(int b) throws IOException {
		
		buffer.write(b);
	}
	
}
