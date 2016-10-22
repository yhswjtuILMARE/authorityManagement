package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Utils.UniqueCode;
import domain.role;
import service.Role2DB;

public class Role extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!this.isTokenValid(request)){
			return null;
		}
		this.resetToken(request);
		role r = (role) form;
		r.setId(UniqueCode.getUUID());
		Role2DB ser = new Role2DB();
		if(ser.add(r)==1){
			request.setAttribute("message", "角色添加成功");
		}else{
			request.setAttribute("message", "角色添加失败");
		}
		return mapping.findForward("message");
	}
	
	

}
