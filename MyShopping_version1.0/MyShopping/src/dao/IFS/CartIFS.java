package dao.IFS;

import java.util.List;

import entity.Cart;

public interface CartIFS {

	public boolean addToCart(Cart cart);
	public List<Cart> showCart();
	public boolean updateCart(Cart cart);
	public Cart getCartById(Integer bid);
	public boolean delCartById(Integer bid);
}
