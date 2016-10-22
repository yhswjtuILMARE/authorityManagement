package interfaces;

import java.util.List;

import domain.Upload;
import domain.page;

public interface mydao {

	public int add(Object obj);
	
	public int delete(String id);
	
	public int update(Object obj);
	
	public int getotalRecord();
	
	public Object select(String id, Class clazz);
	
	public page getPage(int currentPage);
	
	public List getList();
}
