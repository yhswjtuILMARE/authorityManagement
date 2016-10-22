package dao;

import java.util.List;

import Utils.JdbcUtil;
import Utils.ListHandler;
import domain.TempBean;
import domain.URLRecourse;
import domain.page;
import domain.priviledge;
import interfaces.mydao;

public class URLRecourse2DB implements mydao{

	@Override
	public int add(Object obj) {
		
		URLRecourse bean = (URLRecourse) obj;
		String sql = "insert urlrecourse(url) values(?)";
		Object[] params={bean.getUrl()};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int delete(String id) {
		
		String sql = "delete from urlrecourse where url=?";
		Object[] params={id};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getotalRecord() {
		
		String sql = "select count(*) from urlrecourse";
		Object[] params = {};
		return (int) JdbcUtil.query(sql, params, new TotalRecord());
	}

	@Override
	public Object select(String id, Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public page getPage(int currentPage) {
		
		int totalRecord = getotalRecord();
		page p = new page(totalRecord, currentPage);
		
		int contain = p.getPageContain();
		int start = (currentPage - 1) * contain;
		String sql = "select url from urlrecourse limit ?,? ";
		
		Object[] params = {start, p.getPageContain()};
		p.setList((List) JdbcUtil.query(sql, params, new ListHandler(URLRecourse.class)));
		return p;
	}

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
