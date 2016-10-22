package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import Utils.MD5Code;
import domain.user;
import service.User2DB;

public class LoginServlet extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		DynaActionForm df = (DynaActionForm) form;
		User2DB ser = new User2DB();
		user u = (user) ser.select(df.getString("username"), user.class);
		if(u == null){
			request.setAttribute("message", "���û�������");
			return mapping.findForward("message");
		}
		String password = MD5Code.getToken(df.getString("password"));
		if(!password.equals(u.getPassword())){
			
			request.setAttribute("message", "�û����ڵ����벻��ȷ");
			return mapping.findForward("message");
			
		}
		request.getSession().setAttribute("user", u);
		String g = u.getGander().equals("male")?"����":"Ůʿ";
		response.getWriter().write("��½�ɹ�����ӭ����" + u.getNickname() + g + "��ҳ�潫����������ת");
		response.setHeader("refresh", "3;/bookstore/index.jsp");
		return null;
	}
}
