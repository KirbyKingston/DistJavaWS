package StoreBeans;

import StoreModel.Product;
import StoreModel.ProductService;
import StoreModel.Cart;
import StoreModel.CartService;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Mitch
 */

@Named(value = "cartBean")
@SessionScoped
public class CartBean {
        private final CartService cartService;
	private Cart cart;
	private double total;
	/**
	 * Creates a new instance of ShoppingCartBean
	 */
	public CartBean() {
		cartService = new CartService();
		setShoppingCart(cartService.getCart());
	}

	public Cart getShoppingCart() {
		return cart;
	}
	
	public void setTotal(double total){
		cart.getCartItems().forEach((p) -> {
			this.total += p.getProduct().getUnitCost()* p.getCostBeforeDiscount();
		});
	}
	
	public double getTotal(){
		return total;
	}
	
	public void setShoppingCart(Cart cart){
		if(cart != null)
			this.cart = cart;
		setTotal(0);
	}
	
	public String shoppingCart(){
		cart = cartService.getCart();
		return "cart";
	}
}
