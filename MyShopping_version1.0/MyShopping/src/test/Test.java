package test;

import dao.BookDao;
import dao.CartDao;
import dao.UserDao;
import entity.Cart;

public class Test {

	public static void main(String[] args) {
		BookDao bd = new BookDao();
		//System.out.println(bd.getAllBook().size());
		
		
		//UserDao ud = new UserDao();
		//System.out.println(ud.loginCheck("admin", "admin").toString());
		
		Cart c = new Cart(2, "±Ø≤“ ¿ΩÁ", "img/1,PNG", 1, 3);
		CartDao cd = new CartDao();
		//System.out.println(cd.addToCart(c));
		
		System.out.println(cd.showCart().size());
		
		
		//System.out.println(bd.getBookById(1).toString());
	}
	
}
