package Factory;

import interfaces.Authorized2DB;

public class AuthorityFactory {

	private Authorized2DB imple = null;
	private String clazz = null;
	
	public AuthorityFactory(String clazz){
		this.clazz = clazz;
		try {
			imple = (Authorized2DB) Class.forName(clazz).newInstance();
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
	
	public Authorized2DB getInstance(){
		return imple;
	}
}
