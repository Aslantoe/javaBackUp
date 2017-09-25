package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import Utils.DataBaseUtil;

public class BaseDao {
	
	public boolean executeUpdate(String sql,Object[] objs){
		Connection conn = null;
		PreparedStatement ps = null;
	
		try {
			conn = DataBaseUtil.getConnection();
			ps = conn.prepareStatement(sql);
			if(objs != null){
			for (int i = 0; i < objs.length; i++) {
				ps.setObject((i+1), objs[i]);
			}
			}
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DataBaseUtil.closeAll(conn, ps, null);
		}
		
	}
}
