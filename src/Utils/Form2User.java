package Utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import domain.formBean;
import domain.user;

public class Form2User {
	
	public static user Transform(formBean bean){
		
		BeanInfo info = null;
		try {
			user u = new user();
			info = Introspector.getBeanInfo(formBean.class,Object.class);
			PropertyDescriptor pds[] = info.getPropertyDescriptors();
			for(PropertyDescriptor pd : pds){
				String name = pd.getName();
				if(name.equals("passtest") || name.equals("multipartRequestHandler") || name.equals("servlet") || name.equals("servletWrapper"))continue;
				if(name.equals("birthday")){
					PropertyDescriptor pu = new PropertyDescriptor(name,user.class);
					Method method = pu.getWriteMethod();
					String bir = (String) pd.getReadMethod().invoke(bean, null);
					SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
					Date date = dt.parse(bir);
					method.invoke(u, date);
					continue;
				}
				PropertyDescriptor pu = new PropertyDescriptor(name,user.class);
				Method method = pu.getWriteMethod();
				method.invoke(u, pd.getReadMethod().invoke(bean, null));
			}return u;
		} catch (Exception e) {
			
			e.printStackTrace();
		}return null;
	}

}
