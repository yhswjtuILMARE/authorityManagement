package domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class priviledge extends ActionForm{
	
	private String id;
	private String priname;
	private String description;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriname() {
		return priname;
	}
	public void setPriname(String priname) {
		this.priname = priname;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors error = new ActionErrors();
		if(priname == null || priname.trim().equals("")){
			error.add("priname", new ActionMessage("权限名不能为空",false));
		}
		return error;
	}
}
