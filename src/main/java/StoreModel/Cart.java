package StoreModel;

import java.util.ArrayList;

/**
 *
 * @author Mitch
 */
public class Cart {

    private ArrayList<LineItem> cartItems;
    private double cartTotal;

    public Cart(ArrayList<LineItem> cartItems, double cartTotal) {
        setCartItems(cartItems);
        setCartTotal(cartTotal);
    }

    public final ArrayList<LineItem> getCartItems() {
        return cartItems;
    }

    public final void setCartItems(ArrayList<LineItem> cartItems) {
        this.cartItems = cartItems;
    }

    public final double getCartTotal() {
        return cartTotal;
    }

    public final void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }
}
