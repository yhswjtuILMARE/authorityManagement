package service;

import java.util.List;

import Factory.PriviledgeFactory;
import interfaces.User_Priviledge2DB;

public class PriviledgeFromDB {
	
	User_Priviledge2DB dao = new PriviledgeFactory("dao.PriviledgeFromDB").getImple();
	
	public List getPriviledge(String username){
		
		return dao.getPriviledge(username);
	}

}
