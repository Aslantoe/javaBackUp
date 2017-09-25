package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utils.DataBaseUtil;
import dao.IFS.BookIFS;
import entity.Book;

public class BookDao extends BaseDao implements BookIFS{

	@Override
	public List<Book> getAllBook() {
		String sql = "select * from book";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataBaseUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Book b = new Book();
				b.setBid(rs.getInt(1));
				b.setBtitle(rs.getString(2));
				b.setBauthor(rs.getString(3));
				b.setBpublisher(rs.getString(4));
				b.setBprice(rs.getDouble(5));
				b.setBimgurl(rs.getString(6));
				list.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public Book getBookById(Integer bid) {
		String sql = "select * from book where bid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = new Book(); 
		try {
			conn = DataBaseUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			if(rs.next()){
				book.setBid(rs.getInt(1));
				book.setBtitle(rs.getString(2));
				book.setBauthor(rs.getString(3));
				book.setBpublisher(rs.getString(4));
				book.setBprice(rs.getDouble(5));
				book.setBimgurl(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(conn, ps, rs);
		}
		
		return book;
	}

	
	
	
}
