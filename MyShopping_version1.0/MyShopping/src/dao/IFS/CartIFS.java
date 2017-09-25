package dao.IFS;

import java.util.List;

import entity.Cart;

public interface CartIFS {

	public boolean addToCart(Cart cart);
	public List<Cart> showCart();
	
}
