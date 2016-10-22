package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Utils.BeanHandler;
import Utils.JdbcUtil;
import Utils.ListHandler;
import domain.Upload;
import domain.page;
import interfaces.ResultHandler;
import interfaces.mydao;

public class Upload2DB implements mydao{
	
	public int add(Object obj){
		
		Upload up = (Upload)obj;
		String sql = "insert upload(id,username,description,type,location,filename) values(?,?,?,?,?,?)";
		Object[] params={up.getId(),up.getUsername(),up.getDescription(),up.getType(),up.getLocation(),up.getFilename()};
		return JdbcUtil.operate(sql, params);
	}
	
	public int delete(String id){
		
		String sql = "delete from upload where id=?";
		Object[] params={id};
		return JdbcUtil.operate(sql, params);
	}
	
	public int update(Object obj){
		
		Upload up = (Upload)obj;
		String sql = "update upload set username=?,description=?,type=?,location=?,filename=? where id=?";
		Object[] params={up.getUsername(),up.getDescription(),up.getType(),up.getLocation(),up.getId(),up.getFilename()};
		return JdbcUtil.operate(sql, params);
	}
	
	public int getotalRecord(){
		String sql = "select count(*) from upload";
		Object[] params = {};
		return (int) JdbcUtil.query(sql, params, new TotalRecord());
	}
	
	public Object select(String id, Class clazz){
		
		String sql = "select id,username,description,type,location,filename from upload where id=?";
		Object[] params={id};
		return JdbcUtil.query(sql, params, new BeanHandler(clazz));
	}
	
	public page getPage(int currentPage){
		
		int totalRecord = getotalRecord();
		page p = new page(totalRecord, currentPage);
		
		int contain = p.getPageContain();
		int start = (currentPage - 1) * contain;
		String sql = "select id,username,description,type,location,filename from upload limit ?,? ";
		
		Object[] params = {start, p.getPageContain()};
		p.setList((List) JdbcUtil.query(sql, params, new ListHandler(Upload.class)));
		return p;
	}

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}
}

class TotalRecord implements ResultHandler{
	
	@Override
	public Object process(ResultSet res) {
		
		if(res == null)return -1;
		try {
			if(!res.next())return -1;
			return (Integer)res.getInt(1);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}return -1;
	}
}
