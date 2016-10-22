package Gloable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FilterFunction {

	public static String DateFormat(Date date){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
}
