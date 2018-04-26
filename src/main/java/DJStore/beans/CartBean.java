package DJStore.beans;

import DJStore.model.Product;
import DJStore.model.ShoppingCart;
import DJStore.service.ShoppingCartService;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mitch
 */
@Component("cartBean")
@Scope("session")
public class CartBean implements Serializable {

	private final String sessionId;
	private final ShoppingCart cart;
	private final ShoppingCartService cartService = new ShoppingCartService();

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
