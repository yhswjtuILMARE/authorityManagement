package service;

import java.util.List;

import Factory.DaoFactory;
import domain.page;
import domain.priviledge;
import domain.user;
import interfaces.mydao;

public class Priviledge2DB {

mydao dao = new DaoFactory("dao.Priviledge2DB").getImple();
	
	public int add(priviledge pri){
		return dao.add(pri);
	}
	
	public int delete(String username){
		return dao.delete(username);
	}
	
	public int update(priviledge pri){
		return dao.update(pri);
	}
	
	public int getotalRecord(){
		return dao.getotalRecord();
	}
	
	public page getPage(int currentPage){
		return dao.getPage(currentPage);
	}
	
	public List getList(){
		return dao.getList();
	}
	
	public Object select(String username, Class clazz){
		return dao.select(username, clazz);
	}
}
