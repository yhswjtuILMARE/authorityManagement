package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.AuthorityFormBean;
import service.Role_Priviledge_Authority;

public class Authority extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!this.isTokenValid(request)){
			return null;
		}
		this.resetToken(request);
		AuthorityFormBean bean = (AuthorityFormBean) form;
		
		Role_Priviledge_Authority ser = new Role_Priviledge_Authority();
		
		for(int i = 0; i < bean.getSrc_id().length; i++){
			ser.Authority(bean.getDest_id(), bean.getSrc_id()[i]);
			//System.out.println(bean.getSrc_id()[i]);
		}
		request.setAttribute("message", "为角色赋权成功");
		return mapping.findForward("message");
	}
}
