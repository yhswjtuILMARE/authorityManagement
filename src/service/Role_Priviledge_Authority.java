package service;

import Factory.AuthorityFactory;
import Utils.JdbcUtil;
import interfaces.Authorized2DB;

public class Role_Priviledge_Authority {
	
	Authorized2DB imple = new AuthorityFactory("dao.Rle_Priviledge_Authority").getInstance();
	
	public int Authority(String arg0, String arg1) {
		
		return imple.Authority(arg0, arg1);
	}
	
	public int Retract(String arg0, String arg1) {
		
		return imple.Retract(arg0, arg1);
	}

}
