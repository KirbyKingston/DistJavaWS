package StoreModel;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mitch
 */
public class CartService {

    private static final Map<String, Cart> cartItems = new HashMap<>();

    public final Cart getCartItems(String sessionId) {
        Cart cart = cartItems.computeIfAbsent(sessionId,
                (String s) -> new Cart());
        return cart;
    }

    public final void update(String sessionId, Cart cart) {
        cartItems.put(sessionId, cart);
    }

    @Override
    public final String toString() {
        return "CartService{" + '}';
    }

}
