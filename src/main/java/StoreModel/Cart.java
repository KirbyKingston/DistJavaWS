package StoreModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mitch
 */
public class Cart {

    //private int cartId;
    private List<LineItem> cartItems;

    public Cart(List<LineItem> cartItems) {
        setCartItems(cartItems);
    }

    public final void addItem(Product p, int qty){
		cartItems.add(new LineItem(p, qty));
	}
    
    public final List<LineItem> getCartItems() {
        return cartItems;
    }

    public final void setCartItems(List<LineItem> cartItems) {
        this.cartItems = cartItems;
    }

    // Might need ID in future
//    public final int getCartId() {
//        return cartId;
//    }
//
//    public final void setCartId(int cartId) {
//        this.cartId = cartId;
//    }

    
}
