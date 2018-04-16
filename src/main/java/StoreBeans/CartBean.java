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
    private final CartService cs = new CartService();
    private final Cart c;
    private double total;

    public CartBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        sessionId = facesContext.getExternalContext().getSessionId(true);
        c = cs.getCartItems(sessionId);
    }
    
    public Cart getC() {
	    return c;
    }
    
    public int getItemsInCart(){
        return c.getItemsInCart();
    }

    public void addItem(Product product){
        c.add(product);
        cs.updateCart(sessionId, c);
    }

    public void deleteItem(Product product){
        c.remove(product);
    }
}
