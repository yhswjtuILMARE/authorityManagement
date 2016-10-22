package service;

import Factory.DaoFactory;
import domain.Upload;
import domain.page;
import domain.user;
import interfaces.mydao;

public class User2DB {

	mydao dao = new DaoFactory("dao.User2DB").getImple();
	
	public int add(user up){
		return dao.add(up);
	}
	
	public int delete(String username){
		return dao.delete(username);
	}
	
	public int update(user up){
		return dao.update(up);
	}
	
	public int getotalRecord(){
		return dao.getotalRecord();
	}
	
	public page getPage(int currentPage){
		return dao.getPage(currentPage);
	}
	
	public Object select(String username, Class clazz){
		return dao.select(username, clazz);
	}

}
