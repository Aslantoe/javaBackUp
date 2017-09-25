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
		
		Cart c = new Cart(1, "img/1>PNG", "³Ç±¤", 355.0, 1, 3);
		Cart c1 = new Cart(3, 2);
		
		CartDao cd = new CartDao();
		
		System.out.println(cd.delCartById(5));
		
		//System.out.println(cd.updateCart(c1));
		
		//System.out.println(cd.addToCart(c));
		
		//System.out.println(cd.getCartById(2).toString());
		
		//System.out.println(cd.showCart().size());
		
		
		//System.out.println(bd.getBookById(1).toString());
	}
	
}
