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


public class ShowDataServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("method").equals("download")){
			ShowDownload(request,response);
		}else if(request.getParameter("method").equals("user")){
			ShowUser(request, response);
		}else if(request.getParameter("method").equals("priviledge")){
			ShowPriviledge(request,response);
		}else if(request.getParameter("method").equals("role")){
			ShowRole(request,response);
		}else if(request.getParameter("method").equals("url")){
			ShowURL(request,response);
		}
		
	}
	
	public void ShowURL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String page = request.getParameter("page");
		URLRecouese2DB ser = new URLRecouese2DB();
		page p = ser.getPage(Integer.parseInt(page));
		p.setUrl(this.getServletContext().getContextPath() + "/" + this.getServletName() + "?method=url");
		request.setAttribute("data", p);
		request.getRequestDispatcher("/WEB-INF/jsp/URLRecourse.jsp").forward(request, response);
	}
	
	public void ShowRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String page = request.getParameter("page");
		Role2DB ser = new Role2DB();
		page p = ser.getPage(Integer.parseInt(page));
		p.setUrl(this.getServletContext().getContextPath() + "/" + this.getServletName() + "?method=role");
		request.setAttribute("data", p);
		request.getRequestDispatcher("/WEB-INF/jsp/showRole.jsp").forward(request, response);
	}
	
	public void ShowPriviledge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String page = request.getParameter("page");
		Priviledge2DB ser = new Priviledge2DB();
		page p = ser.getPage(Integer.parseInt(page));
		p.setUrl(this.getServletContext().getContextPath() + "/" + this.getServletName() + "?method=priviledge");
		request.setAttribute("data", p);
		request.getRequestDispatcher("/WEB-INF/jsp/showPriviledge.jsp").forward(request, response);
	}
	
	public void ShowUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String page = request.getParameter("page");
		User2DB ser = new User2DB();
		page p = ser.getPage(Integer.parseInt(page));
		p.setUrl(this.getServletContext().getContextPath() + "/" + this.getServletName() + "?method=user");
		request.setAttribute("data", p);
		request.getRequestDispatcher("/WEB-INF/jsp/ShowUser.jsp").forward(request, response);
	}

	public void ShowDownload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String page = request.getParameter("page");
		ser2db ser = new ser2db();
		page p = ser.getPage(Integer.parseInt(page));
		p.setUrl(this.getServletContext().getContextPath() + "/" + this.getServletName() + "?method=download");
		request.setAttribute("data", p);
		request.getRequestDispatcher("/WEB-INF/jsp/showDownload.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
