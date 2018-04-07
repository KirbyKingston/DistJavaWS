package StoreModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import StoreData.ProductDAO;


/**
 *
 * @author Mitch
 */
public class ProductService {
    
    public Product getProduct(String sID) {
        return null;
    }

    public final List<Product> getAllProducts()throws Exception {
        ProductDAO pDAO = new ProductDAO();
        List<Product> productList = pDAO.getProducts();
        if(productList != null){
        }
        return productList;
    }
    

    public final List<Product> findProducts(String search) {
//        search = search.toLowerCase();
//        List<Product> list = new ArrayList<>();
//        for (Product product : productList) {
//            if (product.getId().toLowerCase().contains(search)
//                    || product.getDescription().toLowerCase().contains(search)) {
//                list.add(product);
//            }
//        }
//        return list;
    return null;
    }
}
