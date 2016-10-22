package service;

import Factory.AuthorityFactory;
import interfaces.Authorized2DB;

public class URLRecourse_Priviledge_Authority {
	
	Authorized2DB imple = new AuthorityFactory("dao.URLRecourse_Priviledge_Authority").getInstance();
	
	public int Authority(String id, String url) {
		
		return imple.Authority(id, url);
	}
	
	public int Retract(String id, String url) {
		
		return imple.Retract(id, url);
	}

}
