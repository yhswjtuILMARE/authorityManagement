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
			request.setAttribute("message", "该用户不存在");
			return mapping.findForward("message");
		}
		String password = MD5Code.getToken(df.getString("password"));
		if(!password.equals(u.getPassword())){
			
			request.setAttribute("message", "用户存在但密码不正确");
			return mapping.findForward("message");
			
		}
		request.getSession().setAttribute("user", u);
		String g = u.getGander().equals("male")?"先生":"女士";
		response.getWriter().write("登陆成功，欢迎您！" + u.getNickname() + g + "，页面将在三秒内跳转");
		response.setHeader("refresh", "3;/bookstore/index.jsp");
		return null;
	}
}
