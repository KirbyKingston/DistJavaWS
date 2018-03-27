package StoreModel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Mitch
 */
public class CartService {    

    private static final Map<String, Cart> contents = new HashMap<>();

    public Cart getContents(String sessionId){
        //if shopping cart doesn't exist, it creates one
        Cart cart = contents.computeIfAbsent(sessionId, 
                (String s) -> new Cart());
        return cart;
    }

    public void update(String sessionId, Cart cart){
        contents.put(sessionId, cart);
    }

}
