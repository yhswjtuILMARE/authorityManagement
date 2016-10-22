package domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AuthorityFormBean extends ActionForm {
	
	private String dest_id;
	private String[] src_id;
	public String getDest_id() {
		return dest_id;
	}
	public void setDest_id(String dest_id) {
		this.dest_id = dest_id;
	}
	public String[] getSrc_id() {
		return src_id;
	}
	public void setSrc_id(String[] src_id) {
		this.src_id = src_id;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors error = new ActionErrors();
		if(dest_id == null || dest_id.trim().equals("")){
			error.add("dest_id", new ActionMessage("目的id不能为空",false));
		}
		if(src_id == null || src_id.length == 0){
			error.add("src_id", new ActionMessage("权限id不能为空",false));
		}
		return error;
	}
	
	

}
