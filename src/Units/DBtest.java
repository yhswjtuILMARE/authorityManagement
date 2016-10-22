package Units;

import java.util.List;

import org.junit.Test;

import Utils.BeanHandler;
import Utils.JdbcUtil;
import Utils.ListHandler;
import dao.PriviledgeFromDB;
import domain.Account;
import domain.TempBean;
import interfaces.User_Priviledge2DB;

public class DBtest {
	
	@Test
	public void test(){
		String sql = "insert account(username,money) values(?,?)";
		Object[] params={"jack",10000};
		System.out.println(JdbcUtil.operate(sql, params));
	}
	
	@Test
	public void test1(){
		String sql = "select username,money from account where id=?";
		Object[] params={4};
		Account ac = (Account) JdbcUtil.query(sql, params, new BeanHandler(Account.class));
		System.out.println(ac.getUsername());
	}
	
	@Test
	public void test2(){
		String sql = "select username,money from account";
		Object[] params={};
		List list = (List) JdbcUtil.query(sql, params, new ListHandler(Account.class));
		System.out.println(list.size());
	}
	
	@Test
	public void test3(){
		
		User_Priviledge2DB imple = new PriviledgeFromDB();
		List<TempBean> list = imple.getPriviledge("20133478");
		for(TempBean bean : list){
			System.out.println(bean.getPriname());
		}
	}

}
