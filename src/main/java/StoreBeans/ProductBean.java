package StoreBeans;

import StoreModel.ProductService;
import StoreModel.Product;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Mitch
 */
@ManagedBean(name = "productBean")
@SessionScoped
public final class ProductBean implements Serializable {

    private final ProductService productService = new ProductService();
    @ManagedProperty(name = "product", value = "")
    private Product product;
    @ManagedProperty(name = "products", value = "")
    private List<Product> products;
    @ManagedProperty(name = "searchString", value = "")
    private String searchString;

    public ProductBean() {
        setProducts(productService.getAllProducts());
        System.out.println("new Bean");
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        this.product = product;
    }

    public final List<Product> getProducts() {
        return products;
    }

    public final void setProducts(List<Product> products) {
        this.products = products;
    }

    public final String getSearchString() {
        return searchString;
    }

    public final void setSearchString(String searchString) {
        if (searchString == null || !searchString.isEmpty()) {
            searchString = "";
        } else {
            this.searchString = searchString;
        }
    }

    public final String searchProducts() {
        setProduct(productService.getProduct(searchString));
        if (product == null) {
            return "productList";
        }
        return "productDetail";
    }

    public void productDetail(AjaxBehaviorEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ProductDetail.xhtml");
        } catch (IOException ex) {
            FacesMessage message = new FacesMessage("IOException", product.getId());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
