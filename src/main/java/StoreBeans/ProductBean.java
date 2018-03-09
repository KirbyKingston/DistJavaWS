package StoreBeans;

import StoreModel.ProductService;
import StoreModel.Product;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
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
@ManagedBean(name="productBean")
@SessionScoped
public final class ProductBean implements Serializable {

        private final ProductService productService = new ProductService();
        private Product product;
        
	public ProductBean() {
	}

	public List<Product> getProducts() {
		return products;
	}


	public void productDetail(AjaxBehaviorEvent event){
		try{
			FacesContext.getCurrentInstance().getExternalContext().redirect("/DistJavaWS/ProductDetail.xhtml");
		}catch(IOException e){
			FacesMessage message = new FacesMessage("IOException", product.getId());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

}
