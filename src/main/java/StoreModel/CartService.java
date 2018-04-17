package StoreModel;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mitch
 */
public class CartService {

    private static final Map<String, Cart> contents = new HashMap<>();

    public final Cart getContents(String sessionId) {
        Cart cart = contents.computeIfAbsent(sessionId,
                (String s) -> new Cart());
        return cart;
    }

    public final void update(String sessionId, Cart cart) {
        contents.put(sessionId, cart);
    }

    @Override
    public String toString() {
        return "CartService{" + '}';
    }

}
