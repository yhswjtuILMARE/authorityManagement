package service;

import java.util.List;

import Factory.DaoFactory;
import domain.TempBean;
import domain.URLRecourse;
import domain.page;
import domain.priviledge;
import interfaces.mydao;

public class URLRecouese2DB {
	
	mydao dao = new DaoFactory("dao.URLRecourse2DB").getImple();
	
	public int add(URLRecourse bean){
		
		return dao.add(bean);
	}
	public int delete (String url){
		return dao.delete(url);
	}
	
	public page getPage(int currentPage){
		return dao.getPage(currentPage);
	}
}
