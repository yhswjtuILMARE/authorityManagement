package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.page;
import service.Priviledge2DB;
import service.Role2DB;
import service.URLRecouese2DB;
import service.User2DB;
import service.ser2db;


public class DeletServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("method").equals("download")){	
			DeleteDownload(request,response);
		}else if(request.getParameter("method").equals("user")){
			DeleteUser(request, response);
		}else if(request.getParameter("method").equals("priviledge")){
			DeletePriviledge(request, response);
		}else if(request.getParameter("method").equals("role")){
			DeleteRole(request, response);
		}else if(request.getParameter("method").equals("url")){
			DeleteURL(request, response);
		}
		
	}
	
	public void DeleteURL(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String id = request.getParameter("id");
		URLRecouese2DB ser = new URLRecouese2DB();
		ser.delete(id);
		response.getWriter().write("删除成功");
	}
	
	public void DeleteRole(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String id = request.getParameter("id");
		Role2DB ser = new Role2DB();
		ser.delete(id);
		response.getWriter().write("删除成功");
	}
	
    public void DeletePriviledge(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String id = request.getParameter("id");
		Priviledge2DB ser = new Priviledge2DB();
		ser.delete(id);
		response.getWriter().write("删除成功");
	}

	public void DeleteDownload(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String id = request.getParameter("id");
		ser2db ser = new ser2db();
		ser.delete(id);
		response.getWriter().write("删除成功");
	}
	
	public void DeleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String id = request.getParameter("id");
		User2DB ser = new User2DB();
		ser.delete(id);
		response.getWriter().write("删除成功");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
