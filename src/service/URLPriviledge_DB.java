package service;

import java.util.List;

import Factory.PriviledgeFactory;
import interfaces.User_Priviledge2DB;

public class URLPriviledge_DB {
	
	User_Priviledge2DB dao = new PriviledgeFactory("dao.URLPriviledge_DB").getImple();
	
	public List getPriviledge(String url){
		
		return dao.getPriviledge(url);
	}

}
