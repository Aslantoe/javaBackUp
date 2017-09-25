package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Utils.DataBaseUtil;
import entity.User;

public class UserDao extends BaseDao {

	@SuppressWarnings("resource")
	public User loginCheck(String name,String pwd){
		String sql = "select * from user where uname=? and upwd=?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(2).equals(name) && rs.getString(3).equals(pwd)) {
					User u = new User();
					u.setUid(rs.getInt(1));
					u.setUname(rs.getString(2));
					u.setUpwd(rs.getString(3));
					return u;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(conn, ps, rs);
		}
		return null;
		
	}
	
}
