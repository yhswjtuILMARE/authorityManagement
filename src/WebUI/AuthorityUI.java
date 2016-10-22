package WebUI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.Priviledge2DB;

public class AuthorityUI extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		this.saveToken(request);
		
		String id = request.getParameter("id");
		String rolename = request.getParameter("rolename");
		Priviledge2DB ser = new Priviledge2DB();
		
		List list = ser.getList();
		
		request.setAttribute("id", id);
		request.setAttribute("rolename", rolename);
		request.setAttribute("priviledge", list);
		
		return mapping.findForward("Authority");
	}
}
