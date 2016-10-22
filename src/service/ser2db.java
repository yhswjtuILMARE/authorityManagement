package service;

import Factory.DaoFactory;
import domain.Upload;
import domain.page;
import interfaces.mydao;

public class ser2db {
	
	mydao dao = new DaoFactory("dao.Upload2DB").getImple();
	
	public int add(Upload up){
		return dao.add(up);
	}
	
	public int delete(String id){
		return dao.delete(id);
	}
	
	public int update(Upload up){
		return dao.update(up);
	}
	
	public int getotalRecord(){
		return dao.getotalRecord();
	}
	
	public page getPage(int currentPage){
		return dao.getPage(currentPage);
	}
	
	public Object select(String id, Class clazz){
		return dao.select(id, clazz);
	}

}
