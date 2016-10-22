package Utils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import interfaces.ResultHandler;

public class JdbcUtil {
	
	private static ComboPooledDataSource con = null;
	
	static{
		con = new ComboPooledDataSource("mysql");
	}
	
	private static Connection getConnection() throws SQLException{
		
		return con.getConnection();
	}

	private static void getRelease(Connection con, Statement st, ResultSet result){
		
		if(result != null){
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static int operate(String sql, Object[] params){
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet res = null;
		try {
			con = getConnection();
			st = con.prepareStatement(sql);
			ParameterMetaData pm = st.getParameterMetaData();
			int ColumnCount = pm.getParameterCount();
			for(int i = 0; i < ColumnCount; i++){
				st.setObject(i+1, params[i]);
			}
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			getRelease(con, st, res);
		}return 0;
	}
	
	public static Object query(String sql,Object[] params, ResultHandler rh){
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet res = null;
		
		try {
			con = getConnection();
			st = con.prepareStatement(sql);
			ParameterMetaData pm = st.getParameterMetaData();
			int ColumnCount = pm.getParameterCount();
			for(int i = 0; i < ColumnCount; i++){
				st.setObject(i+1, params[i]);
			}
			res = st.executeQuery();
			return rh.process(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			getRelease(con, st, res);
		}return null;
	}
}
