package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.AuthorityFormBean;
import service.URLRecourse_Priviledge_Authority;

public class URLAuthority extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!this.isTokenValid(request)){
			return null;
		}
		this.resetToken(request);
		
		AuthorityFormBean bean = (AuthorityFormBean) form;
		
		URLRecourse_Priviledge_Authority ser = new URLRecourse_Priviledge_Authority();
		for(int i = 0; i < bean.getSrc_id().length; i++){
			ser.Authority(bean.getSrc_id()[i], bean.getDest_id());
		}
		request.setAttribute("message", "为URL赋权成功");
		return mapping.findForward("message");
	}
	
	

}
