package Controller;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Utils.UniqueCode;
import domain.Upload;
import service.ser2db;


public class UploadServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Upload up = new Upload();
		ser2db ser = new ser2db();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding(request.getCharacterEncoding());
		String path = this.getServletContext().getRealPath("/upload");
		factory.setRepository(new File(this.getServletContext().getRealPath("/temp")));
		if(!upload.isMultipartContent(request)){
			return;
		}
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list){
				if(item.isFormField()){
					String name = item.getFieldName();
					String value = item.getString(request.getCharacterEncoding());
					PropertyDescriptor pd = new PropertyDescriptor(name, Upload.class);
					Method method = pd.getWriteMethod();
					method.invoke(up, value);
				}else{
					String filename = item.getName();
					if(filename == null || filename.trim().equals(""))continue;
					filename = filename.substring(filename.lastIndexOf("//")+1);
					PropertyDescriptor pd = new PropertyDescriptor("filename", Upload.class);
					Method method = pd.getWriteMethod();
					method.invoke(up, filename);
					filename = UniqueCode.getUUID() + "_" + filename;
					String filepath = getPath(path ,filename);
					pd = new PropertyDescriptor("location", Upload.class);
					method = pd.getWriteMethod();
					method.invoke(up, filepath + "\\" + filename);
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(filepath + "\\" + filename);
					byte[] buffer = new byte[1024];
					int len = in.read(buffer);
					while(len != -1){
						out.write(buffer, 0, len);
						len = in.read(buffer);
					}
					in.close();
					out.close();
					item.delete();
				}
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		up.setId(UniqueCode.getUUID());
		ser.add(up);
	}
	
	public String getPath(String path ,String filename){
		
		int hashcode = filename.hashCode();
		int dir1 = hashcode&0xf;
		int dir2 = (hashcode&0xf0)>>4;
		String filepath = path + "\\" + dir1 + "\\" + dir2;
		File file = new File(filepath);
		if(!file.exists()){
			file.mkdirs();
		}return filepath;
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
