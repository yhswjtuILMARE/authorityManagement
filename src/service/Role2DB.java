 package service;

import java.util.List;

import Factory.DaoFactory;
import domain.page;
import domain.role;
import domain.user;
import interfaces.mydao;

public class Role2DB {
	
	mydao dao = new DaoFactory("dao.Role2DB").getImple();
	
	public int add(role r){
		return dao.add(r);
	}
	
	public int delete(String username){
		return dao.delete(username);
	}
	
	public int update(role r){
		return dao.update(r);
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
	
	public List getList(){
		return dao.getList();
	}
}
