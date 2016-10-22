package dao;

import Utils.JdbcUtil;
import interfaces.Authorized2DB;

public class User_Role_Authority implements Authorized2DB {

	@Override
	public int Authority(String arg0, String arg1) {
		
		String sql = "insert user_role(username,id) values(?,?)";
		Object[] params={arg0,arg1};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int Retract(String arg0, String arg1) {
		String sql = "delete from user_role where username=? and id=?";
		Object[] params={arg0,arg1};
		return JdbcUtil.operate(sql, params);
	}

}
