package StoreBeans;

import StoreModel.Product;
import StoreModel.ProductService;
import StoreModel.Cart;
import StoreModel.CartService;
import StoreModel.LineItem;
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
	private final Cart cart;
	private double total;
	
	public CartBean() {
            cartService = new CartService();
            cart = cartService.getCart();
	}

	
	public final List<LineItem> getItemsInCart(){
            return cart.getCartItems();
        }
	
	
}
