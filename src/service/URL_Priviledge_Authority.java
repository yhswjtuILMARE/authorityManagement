package service;

import Factory.AuthorityFactory;
import interfaces.Authorized2DB;

public class URL_Priviledge_Authority {
	
	Authorized2DB imple = new AuthorityFactory("dao.URLRecourse_Priviledge_Authority").getInstance();
	
	public int Authority(String priviledge_id, String url) {
		
		return imple.Authority(priviledge_id, url);
	}
	
	public int Retract(String priviledge_id, String url) {
		
		return imple.Retract(priviledge_id, url);
	}

}
