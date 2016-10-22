package dao;

import java.sql.Date;
import java.util.List;

import Utils.BeanHandler;
import Utils.JdbcUtil;
import Utils.ListHandler;
import domain.Upload;
import domain.page;
import domain.user;
import interfaces.mydao;

public class User2DB implements mydao {

	@Override
	public int add(Object obj) {
		user use = (user) obj;
		String sql = "insert user(username,password,gander,email,birthday,nickname) values(?,?,?,?,?,?)";
		Date bir = new Date(use.getBirthday().getTime());
		Object[] params={use.getUsername(),use.getPassword(),use.getGander(),use.getEmail(),bir,use.getNickname()};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int delete(String username) {
		
		String sql = "delete from user where username=?";
		Object[] params={username};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int update(Object obj) {
		
		user use = (user) obj;
		String sql = "update user set email=?,birthday=?,nickname=? where username=?";
		Date bir = new Date(use.getBirthday().getTime());
		Object[] params={use.getEmail(),bir,use.getNickname(),use.getUsername()};
		return JdbcUtil.operate(sql, params);
	}

	@Override
	public int getotalRecord() {
		String sql = "select count(*) from user";
		Object[] params = {};
		return (int) JdbcUtil.query(sql, params, new TotalRecord());
	}

	@Override
	public Object select(String username, Class clazz) {
		
		String sql = "select username,password,gander,email,birthday,nickname from user where username=?";
		Object[] params={username};
		return JdbcUtil.query(sql, params, new BeanHandler(clazz));
	}

	@Override
	public page getPage(int currentPage) {
		
		int totalRecord = getotalRecord();
		page p = new page(totalRecord, currentPage);
		
		int contain = p.getPageContain();
		int start = (currentPage - 1) * contain;
		String sql = "select username,password,gander,email,birthday,nickname from user limit ?,? ";
		
		Object[] params = {start, p.getPageContain()};
		p.setList((List) JdbcUtil.query(sql, params, new ListHandler(user.class)));
		return p;
	}

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}
}
