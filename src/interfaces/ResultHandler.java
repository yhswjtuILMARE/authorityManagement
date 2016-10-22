package interfaces;

import java.sql.ResultSet;

public interface ResultHandler {
	
	public Object process(ResultSet res);

}
