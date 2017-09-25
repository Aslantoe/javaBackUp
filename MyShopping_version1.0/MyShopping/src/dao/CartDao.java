package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utils.DataBaseUtil;
import dao.IFS.CartIFS;
import entity.Cart;

public class CartDao extends BaseDao implements CartIFS{

	@Override
	public boolean addToCart(Cart cart) {
		String sql = "insert into cart values(?,?,?,?,?);";
		Object[] objs = {
			cart.getCid(),
			cart.getBtitle(),
			cart.getBimgurl(),
			cart.getBcount(),
			cart.getBid()
		};
		return executeUpdate(sql, objs);
	}

	@Override
	public List<Cart> showCart() {
		String sql = "select * from cart";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Cart> list = new ArrayList<Cart>();
		 try {
			conn = DataBaseUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Cart c = new Cart();
				c.setCid(rs.getInt(1));
				c.setBtitle(rs.getString(2));
				c.setBimgurl(rs.getString(3));
				c.setBcount(rs.getInt(4));
				c.setBid(rs.getInt(5));
				list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(conn, ps, rs);
		}
		return list;
	}

	
}
