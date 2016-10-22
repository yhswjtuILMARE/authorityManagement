package Utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import interfaces.ResultHandler;

public class ListHandler implements ResultHandler {

	private Class clazz = null;
	private List list = new LinkedList();
	
	public ListHandler(Class clazz){
		this.clazz = clazz;
	}
	
	public Object process(ResultSet res) {

		if(res == null)return null;
		try {
			if(!res.next())return null;
			res.previous();
			while(res.next()){
				Object value = clazz.newInstance();
				ResultSetMetaData rm = res.getMetaData();
				int ColumnCount = rm.getColumnCount();
				for(int i = 0; i < ColumnCount; i++){
					String name = rm.getColumnName(i+1);
					Object msg = res.getObject(i+1);
					Field field = clazz.getDeclaredField(name);
					field.setAccessible(true);
					field.set(value, msg);
				}
				list.add(value);
			}return list;
		} catch (Exception e) {

			e.printStackTrace();
		}return null;
	}

}
