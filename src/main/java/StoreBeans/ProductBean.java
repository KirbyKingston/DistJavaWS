package StoreBeans;

import StoreService.ProductService;
import StoreModel.Product;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Mitch
 */
@SessionScoped
@ManagedBean(name = "productBean")
@Dependent
public final class ProductBean implements Serializable {

    private String searchString;
    private final ProductService productService = new ProductService();
    private List<Product> products;
    private Product product;

    public ProductBean() throws Exception {
        setProducts(productService.getAllProducts());
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product p) {
        product = p;
        System.out.println("product = " + product);
    }

    public final List<Product> getProducts() {
        return products;
    }

    public final void setProducts(List<Product> p) {
        if (p != null) {
            products = p;
        }
        System.out.println("products = " + products);
    }

    public final String getSearchString() {
        return searchString;
    }

    public final void setSearchString(String search) {
        searchString = search;
        System.out.println("searchString = " + searchString);
    }

//    public String searchProductsById() throws Exception {
//        System.out.println(searchString);
//        setProduct((Product) productService.findProducts(searchString));
//        System.out.println(product);
//        if (product == null) {
//            return "ProductList";
//        }
//        return "ProductDetail";
//    }

    public final String searchProducts() throws Exception {
        List<Product> productSearchList = productService.findProducts(searchString);
        System.out.println(productSearchList);
        if (productSearchList == null) {
            System.out.println("null productSearchList");
            return "ProductList";
        }
        System.out.println("good productSearchList");
        return "ProductList";
    }

    public void productDetail(AjaxBehaviorEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/DistJavaWS/ProductDetail.xhtml");
        } catch (IOException ex) {
            FacesMessage message = new FacesMessage("IOException", product.getId());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
