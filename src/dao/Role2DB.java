package dao;

import java.sql.Date;
import java.util.List;

import Utils.BeanHandler;
import Utils.JdbcUtil;
import Utils.ListHandler;
import domain.page;
import domain.priviledge;
import domain.role;
import domain.user;
import interfaces.mydao;

public class Role2DB implements mydao {

	@Override
	public int add(Object obj) {
		
		role r = (role) obj;
		String sql = "insert role(id,rolename,description) values(?,?,?)";
		Object[] params={r.getId(),r.getRolename(),r.getDescription()};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int delete(String id) {
		
		String sql = "delete from role where id=?";
		Object[] params={id};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int update(Object obj) {
		
		
		return 0;
	}

	@Override
	public int getotalRecord() {
		
		String sql = "select count(*) from role";
		Object[] params = {};
		return (int) JdbcUtil.query(sql, params, new TotalRecord());
	}

	@Override
	public Object select(String id, Class clazz) {
		
		String sql = "select id,rolename,description from role where id=?";
		Object[] params={id};
		return JdbcUtil.query(sql, params, new BeanHandler(clazz));
	}

	@Override
	public page getPage(int currentPage) {
		
		int totalRecord = getotalRecord();
		page p = new page(totalRecord, currentPage);
		
		int contain = p.getPageContain();
		int start = (currentPage - 1) * contain;
		String sql = "select id,rolename,description from role limit ?,? ";
		
		Object[] params = {start, p.getPageContain()};
		p.setList((List) JdbcUtil.query(sql, params, new ListHandler(role.class)));
		return p;
	}

	@Override
	public List getList() {
		
		String sql = "select id,rolename,description from role";
		Object[] params = {};
		return (List) JdbcUtil.query(sql, params, new ListHandler(role.class));
	}

}
