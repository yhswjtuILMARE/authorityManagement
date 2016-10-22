package dao;

import java.util.List;

import Utils.JdbcUtil;
import Utils.ListHandler;
import domain.TempBean;
import interfaces.User_Priviledge2DB;

public class URLPriviledge_DB implements User_Priviledge2DB {

	@Override
	public List getPriviledge(String url) {
		
		String sql = "select priname from priviledge,priviledge_url where priviledge.id = priviledge_url.priviledge_id and priviledge_url.url=?";
		Object[] params = {url};
		return (List) JdbcUtil.query(sql, params, new ListHandler(TempBean.class));
	}

}
