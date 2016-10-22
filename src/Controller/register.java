package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Utils.Form2User;
import Utils.MD5Code;
import domain.formBean;
import domain.role;
import domain.user;
import service.Role2DB;
import service.User2DB;
import service.User_Role_Authority;

public class register extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if(!isTokenValid(request)){
			return null;
		}
		resetToken(request);
		User2DB ser = new User2DB();
		Role2DB role = new Role2DB();
		User_Role_Authority service = new User_Role_Authority();
		List<role> list = role.getList();
		String role_id = "";
		for(role r : list){
			if(r.getRolename().equals("һ���û�")){
				role_id = r.getId();
			}
		}
		
		formBean forms = (formBean) form;
		user u = Form2User.Transform(forms);
		u.setPassword(MD5Code.getToken(u.getPassword()));
		if(ser.add(u) == 1){
			if(service.Authority(u.getUsername(), role_id) == 1){
				request.setAttribute("message", "ע��ɹ�����3������ת");
			}else{
				request.setAttribute("message", "ע��ʧ��");
			}
		}else{
			request.setAttribute("message", "ע��ʧ��");
		}
		response.setHeader("refresh", "3;/bookstore/index.jsp");
		return mapping.findForward("message");
	}
	
	

}
