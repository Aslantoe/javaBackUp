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
		String sql = "insert into cart values(?,?,?,?,?,?);";
		Object[] objs = {
			cart.getCid(),
			cart.getBimgurl(),
			cart.getBtitle(),
			cart.getBprice(),
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
				c.setBimgurl(rs.getString(2));
				c.setBtitle(rs.getString(3));
				c.setBprice(rs.getDouble(4));
				c.setBcount(rs.getInt(5));
				c.setBid(rs.getInt(6));
				list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(conn, ps, rs);
		}
		return list;
	}


	@Override
	public boolean updateCart(Cart cart) {
		String sql = "update cart  set bcount = ? where bid = ?";
		Object[] objs = {
				cart.getBcount(),
				cart.getBid()
		};
		return executeUpdate(sql, objs);
	}

	@Override
	public Cart getCartById(Integer bid) {
		String sql = "select bid,bcount from cart where bid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			Cart c = null;
			if(rs.next()){
			    c = new Cart();
				c.setBid(rs.getInt("bid"));
				c.setBcount(rs.getInt("bcount"));
			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public boolean delCartById(Integer bid) {
		String sql = "delete from cart where cid = ?";
		Object[] objs = {bid};
		return executeUpdate(sql, objs);
	}

	
}
