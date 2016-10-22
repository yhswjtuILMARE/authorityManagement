package Utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import interfaces.ResultHandler;

public class BeanHandler implements ResultHandler {

	private Class clazz = null;
	
	public BeanHandler(Class clazz){
		this.clazz = clazz;
	}
	@Override
	public Object process(ResultSet res) {
		
		if(res==null)return null;
		try {
			if(!res.next())return null;
			Object value = clazz.newInstance();
			ResultSetMetaData rs = res.getMetaData();
			int ColumnCount = rs.getColumnCount();
			for(int i = 0; i < ColumnCount; i++){	
				String name = rs.getColumnName(i+1);
				Object msg = res.getObject(i+1);
				Field field = clazz.getDeclaredField(name);
				field.setAccessible(true);
				field.set(value, msg);
			}return value;
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}

}
