package domain;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class formBean extends ActionForm {

	private String username;
	private String password;
	private String passtest;
	private String gander;
	private String email;
	private String birthday;
	private String nickname;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasstest() {
		return passtest;
	}
	public void setPasstest(String passtest) {
		this.passtest = passtest;
	}
	public String getGander() {
		return gander;
	}
	public void setGander(String gander) {
		this.gander = gander;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors error = new ActionErrors();
		if(username == null || username.trim().equals("")){
			error.add("username", new ActionMessage("�û�������Ϊ��", false));
		}else{
			if(!username.matches("[A-Za-z0-9]{3,8}")){
				error.add("username", new ActionMessage("�û�������Ϊ3-8λ��ĸ������", false));
			}
		}
		
		if(password == null || password.trim().equals("")){
			error.add("password", new ActionMessage("���벻��Ϊ��", false));
		}else{
			if(!password.matches("\\d{3,8}")){
				error.add("password", new ActionMessage("�������Ϊ3-8λ����", false));
			}
		}
		
		if(passtest == null || passtest.trim().equals("")){
			error.add("passtest", new ActionMessage("У�����벻��Ϊ��", false));
		}else{
			if(!passtest.equals(password)){
				error.add("passtest", new ActionMessage("�����������벻һ��", false));
			}
		}
		
		if(email == null || email.trim().equals("")){
			error.add("email", new ActionMessage("���䲻��Ϊ��", false));
		}else{
			if(!email.matches("\\w+@\\w+(\\.\\w+)+")){
				error.add("email", new ActionMessage("�����ʽ����ȷ", false));
			}
		}
		
		if(birthday != null && !birthday.trim().equals("")){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				df.parse(birthday);
			} catch (Exception e) {
				error.add("birthday", new ActionMessage("���ո�ʽ����ȷ", false));
			}
		}
		
		if(nickname == null || nickname.trim().equals("")){
			error.add("nickname", new ActionMessage("�ǳƲ���Ϊ��", false));
		}else{
			if(!nickname.matches("[A-Za-z]{3,8}")){
				error.add("nickname", new ActionMessage("�ǳƱ���Ϊ3-8Ϊ��ĸ������", false));
			}
		}return error;
	}
}