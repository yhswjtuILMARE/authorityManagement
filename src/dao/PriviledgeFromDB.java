package dao;

import java.util.List;

import Utils.JdbcUtil;
import Utils.ListHandler;
import domain.TempBean;
import interfaces.User_Priviledge2DB;

public class PriviledgeFromDB implements User_Priviledge2DB {

	public List getPriviledge(String username) {
		
		String sql = "select DISTINCT priname from user,role,priviledge,user_role,role_priviledge where user.username = user_role.username and user_role.id = role.id and role.id = role_priviledge.role_id and role_priviledge.priviledge_id = priviledge.id and user.username=?";
		Object[] params = {username};
		return (List) JdbcUtil.query(sql, params, new ListHandler(TempBean.class));
	}

}
