package Factory;

import interfaces.User_Priviledge2DB;
import interfaces.mydao;

public class PriviledgeFactory {
	
	private User_Priviledge2DB imple = null;
	private String clazz = null;
	
	public PriviledgeFactory(String clazz){
		this.clazz = clazz;
		try {
			imple = (User_Priviledge2DB) Class.forName(clazz).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User_Priviledge2DB getImple(){
		return imple;
	}
}
