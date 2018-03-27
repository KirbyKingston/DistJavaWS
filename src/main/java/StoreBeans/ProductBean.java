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
@SessionScoped
@ManagedBean(name = "productBean")

public final class ProductBean implements Serializable {

    @ManagedProperty(name = "searchString", value = "")
    private String searchString;
    private final ProductService productService = new ProductService();
    @ManagedProperty(name = "products", value = "")
    private List<Product> products;
    @ManagedProperty(name = "product", value = "")
    private Product product;
    
    public ProductBean() {
        setProducts(productService.getAllProducts());
        System.out.println("new Bean");
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
        if(p != null)
 products = p;
        System.out.println("products = " + products);
    }

    public final String getSearchString() {
        return searchString;
    }

    public final void setSearchString(String search) {
            searchString = search;
            System.out.println("searchString = " + searchString);
    }

    public String searchProductsById(){
//		if(searchId == null)
//			searchId = "S001";
		System.out.println(searchString);
		setProduct(productService.getProduct(searchString));
		System.out.println(product);
		if(product == null)
			return "ProductList";
		return "ProductDetail";
	}
    
    public final String searchProducts() {
        setProduct(productService.getProduct(searchString));
        if (product == null) {
            return "ProductList";
        }
        return "ProductDetail";
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
