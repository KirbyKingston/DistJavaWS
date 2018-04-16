package StoreBeans;

import StoreModel.Product;
import StoreModel.Cart;
import StoreModel.CartService;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Mitch
 */
@Named(value = "cartBean")
@SessionScoped
public class CartBean implements Serializable {

    private final String sessionId;
    private final CartService cartService = new CartService();
    private final Cart cart;
    private double total;

    public CartBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        sessionId = facesContext.getExternalContext().getSessionId(true);
        cart = cartService.getCartItems(sessionId);
    }
    
    public Cart getCart() {
	    return cart;
    }
    
    public int getItemsInCart(){
        return cart.getItemsInCart();
    }

    public void addToCart(Product product){
        cart.add(product);
        cartService.update(sessionId, cart);
    }

    public void deleteFromCart(Product product){
        cart.remove(product);
    }
}
