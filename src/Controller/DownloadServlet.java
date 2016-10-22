package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Upload;
import service.ser2db;


public class DownloadServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if(id == null || id.trim().equals(""))return;
		ser2db ser = new ser2db();
		Upload up = (Upload) ser.select(id, Upload.class);
		String path = up.getLocation();
		File file = new File(path);
		if(!file.exists()){
			response.getWriter().write("对不起，您需要的资源已取消");
		}
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(up.getFilename(), "UTF-8"));
		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(path);
		byte[] buffer = new byte[1024];
		int len = in.read(buffer);
		while(len != -1){
			out.write(buffer, 0, len);
			len = in.read(buffer);
		}
		in.close();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
