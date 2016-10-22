package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.TempBean;
import domain.URLRecourse;
import domain.user;
import service.PriviledgeFromDB;
import service.URLPriviledge_DB;
import service.URLRecouese2DB;


public class RightFilter implements Filter {
	
	private List<TempBean> list = null;
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		PriviledgeFromDB priviledge = new PriviledgeFromDB();
		URLPriviledge_DB url = new URLPriviledge_DB();
		
		List<TempBean> list = url.getPriviledge(request.getRequestURI());
		if(list == null || list.size() == 0){
			chain.doFilter(request, response);
			return;
		}
			
		/*URLRecouese2DB ser = new URLRecouese2DB();//为数据库中添加URL资源
		URLRecourse bean = new URLRecourse();
		bean.setUrl(request.getRequestURI());
		ser.add(bean);*/
		
		HttpSession session = request.getSession(false);
		if(session == null){
			request.setAttribute("message", "检测到您尚未登录");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		user u = (user) session.getAttribute("user");
		
		if(u == null){

			request.setAttribute("message", "检测到您尚未登录");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		List<TempBean> UserList = priviledge.getPriviledge(u.getUsername());
		
		if(UserList != null){
			for(TempBean urlbean : list){
				for(TempBean userbean : UserList){
					if(urlbean.getPriname().equals(userbean.getPriname())){
						chain.doFilter(request, response);
						return;
					}
				}
			}
		}else{
			response.getWriter().write("尊敬的" + u.getNickname() + "，对不起，您没有访问权限，请联系管理员");
			return;
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}
	
	public void destroy() {
		
	}
}
