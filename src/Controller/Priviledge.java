package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Utils.UniqueCode;
import domain.priviledge;
import service.Priviledge2DB;

public class Priviledge extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!this.isTokenValid(request)){
			return null;
		}
		this.resetToken(request);
		priviledge pri = (priviledge) form;
		pri.setId(UniqueCode.getUUID());
		
		Priviledge2DB ser = new Priviledge2DB();
		if(ser.add(pri) == 1){
			request.setAttribute("message", "权限添加成功");
		}else{
			request.setAttribute("message", "权限添加失败");
		}
		return mapping.findForward("message");
	}
}
