package dao;

import Utils.JdbcUtil;
import interfaces.Authorized2DB;

public class Rle_Priviledge_Authority implements Authorized2DB {

	@Override
	public int Authority(String arg0, String arg1) {
		
		String sql = "insert role_priviledge(role_id,priviledge_id) values(?,?)";
		Object[] params={arg0,arg1};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int Retract(String arg0, String arg1) {
		
		String sql = "delete from role_priviledge where role_id=? and priviledge_id=?";
		Object[] params={arg0,arg1};
		return JdbcUtil.operate(sql, params);
	}

}
