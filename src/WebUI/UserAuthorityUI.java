package WebUI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.Priviledge2DB;
import service.Role2DB;

public class UserAuthorityUI extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		this.saveToken(request);
		
		String id = request.getParameter("id");
		
		Role2DB ser = new Role2DB();
		List list = ser.getList();
		
		request.setAttribute("id", id);
		request.setAttribute("role", list);
		
		return mapping.findForward("userAuthorityUI");
	}
	
	
	

}
