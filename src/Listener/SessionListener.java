package Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		ServletContext context = event.getSession().getServletContext();
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		

	}

}
