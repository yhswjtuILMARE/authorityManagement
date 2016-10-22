package Factory;

import interfaces.mydao;

public class DaoFactory {
	
	private mydao imple = null;
	private String clazz = null;
	
	public DaoFactory(String clazz){
		this.clazz = clazz;
		try {
			imple = (mydao) Class.forName(clazz).newInstance();
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
	
	public mydao getImple(){
		return imple;
	}

}
