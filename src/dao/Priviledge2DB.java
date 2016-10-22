package dao;

import java.sql.Date;
import java.util.List;

import Utils.BeanHandler;
import Utils.JdbcUtil;
import Utils.ListHandler;
import domain.TempBean;
import domain.page;
import domain.priviledge;
import domain.user;
import interfaces.mydao;

public class Priviledge2DB implements mydao {

	@Override
	public int add(Object obj) {
		
		priviledge pri = (priviledge) obj;
		String sql = "insert priviledge(id,priname,description) values(?,?,?)";
		Object[] params={pri.getId(),pri.getPriname(),pri.getDescription()};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int delete(String id) {
		
		String sql = "delete from priviledge where id=?";
		Object[] params={id};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int update(Object obj) {
		
		return 0;
	}

	@Override
	public int getotalRecord() {
		
		String sql = "select count(*) from priviledge";
		Object[] params = {};
		return (int) JdbcUtil.query(sql, params, new TotalRecord());
	}

	@Override
	public Object select(String id, Class clazz) {
		
		String sql = "select id,priname,description from priviledge where id=?";
		Object[] params={id};
		return JdbcUtil.query(sql, params, new BeanHandler(clazz));
	}
	
	public List getList() {
		
		String sql = "select id,priname,description from priviledge";
		Object[] params = {};
		return (List) JdbcUtil.query(sql, params, new ListHandler(priviledge.class));
	}

	@Override
	public page getPage(int currentPage) {
		
		int totalRecord = getotalRecord();
		page p = new page(totalRecord, currentPage);
		
		int contain = p.getPageContain();
		int start = (currentPage - 1) * contain;
		String sql = "select id,priname,description from priviledge limit ?,? ";
		
		Object[] params = {start, p.getPageContain()};
		p.setList((List) JdbcUtil.query(sql, params, new ListHandler(priviledge.class)));
		return p;
	}
}
