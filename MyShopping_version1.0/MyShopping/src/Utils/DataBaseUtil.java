package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtil {

	private static final String  NAME = "root";
	private static final String  PASSWORD = "mysql";
	private static final String  DRIVERNAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/myjd";
	

	static{
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
