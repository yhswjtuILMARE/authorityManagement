package dao;

import Utils.JdbcUtil;
import interfaces.Authorized2DB;

public class URLRecourse_Priviledge_Authority implements Authorized2DB {

	@Override
	public int Authority(String arg0, String arg1) {
		
		String sql = "insert priviledge_url(priviledge_id,url) values(?,?)";
		Object[] params={arg0,arg1};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int Retract(String arg0, String arg1) {
		
		String sql = "delete from priviledge_url where priviledge_id=? and url=?";
		Object[] params={arg0,arg1};
		return JdbcUtil.operate(sql, params);
	}

}
