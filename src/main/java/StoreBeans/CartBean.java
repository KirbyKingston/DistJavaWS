package StoreBeans;

import StoreModel.Product;
import StoreModel.Cart;
import StoreModel.CartService;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author Mitch
 */
@SessionScoped
@ManagedBean(name = "cartBean")
@Dependent
public class CartBean implements Serializable {

//    private final String sessionId;
//    private final Cart cart;
    private Product product;
    private final CartService cartService;
    private double total;
    private Integer amount;
    private String currentProductId;

    public CartBean() {
        cartService = new CartService();
        setTotal();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
        System.out.println("amount = " + this.amount);
    }

    public Cart getCart() {
        return cartService.getCart();
    }

    public String getCurrentProductId() {
        return currentProductId;
    }

    public void setTotal() {
        this.total = 0;
        getCart().getProducts().forEach((p) -> {
            this.total += p.getUnitCost() * getCart().getQuantityFor(p);
        });
    }

    public double getTotal() {
        return total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product p) {
        this.product = p;
    }

//    public int getItemsInCart() {
//        return cart.getItemsInCart();
//    }
//
//    public void addToCart(product p, amount a) {
//        this.cartService.addItem(p, a);
//    }
//
//    public void deleteItem(Product p) {
//        cart.remove(p);
//    }
    public void addToCart(AjaxBehaviorEvent event) {
        if (this.amount == null) {
            throw new IllegalArgumentException("");
        }
        if (this.product == null) {
            throw new IllegalArgumentException("");
        }
        this.cartService.addItem(product, this.amount);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/DistJavaWS/ProductDetail.xhtml");
        } catch (IOException e) {
            FacesMessage message = new FacesMessage("IOException", product.getId());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void newAmount(ValueChangeEvent e) {
        this.setAmount(Integer.valueOf(e.getNewValue().toString()));
        throw new IllegalArgumentException();
    }
}
