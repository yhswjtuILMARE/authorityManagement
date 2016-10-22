package service;

import Factory.AuthorityFactory;
import interfaces.Authorized2DB;

public class User_Role_Authority {

	Authorized2DB imple = new AuthorityFactory("dao.User_Role_Authority").getInstance();
	
	public int Authority(String arg0, String arg1) {
		
		return imple.Authority(arg0, arg1);
	}
	
	public int Retract(String arg0, String arg1) {
		
		return imple.Retract(arg0, arg1);
	}
}
