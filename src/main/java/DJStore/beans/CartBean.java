package DJStore.beans;

import DJStore.entity.Product;
import DJStore.entity.Cart;
import DJStore.service.CartService;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mitch
 */
@Component("cartBean")
@Scope("session")
public class CartBean implements Serializable {

    @Autowired
    private CartService cartService;

    private final String sessionId;
    private final Cart cart;

    public CartBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        sessionId = facesContext.getExternalContext().getSessionId(true);
        cart = cartService.getContents(sessionId);
    }

    public int getItemsInCart() {
        return cart.getItemsInCart();
    }

    public void addToCart(Product p) {
        cart.add(p);
        cartService.update(sessionId, cart);
    }

}
