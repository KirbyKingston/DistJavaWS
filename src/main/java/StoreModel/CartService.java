package StoreModel;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mitch
 */
public class CartService {

    
    private List<LineItem> lineItems = Arrays.asList();

    private Cart cart = new Cart(lineItems);
    
    public final Cart getCart() {
        return cart;
    }

    public final void setCart(Cart cart) {
        this.cart = cart;
    }
    
    public final List<LineItem> getLineItems() {
        return lineItems;
    }

    public final void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

}
