package StoreModel;

import java.util.ArrayList;
import java.util.List;
import StoreData.ProductDAO;

/**
 *
 * @author Mitch
 */
public class ProductService {

    public final List<Product> getAllProducts() throws Exception {
        ProductDAO pDAO = new ProductDAO();
        List<Product> productList = pDAO.getProducts();
        if (productList != null) {
        }
        return productList;
    }

    public List<Product> findProducts(String search) throws Exception {
        ProductDAO pDAO = new ProductDAO();
        List<Product> productList = pDAO.getProducts();
        List<Product> list = new ArrayList<>();
        productList.stream().filter((product) -> (product.getId().toLowerCase().contains(search)
                || product.getDescription().toLowerCase().contains(search))).forEachOrdered((product) -> {
                    list.add(product);
        });
        return list;
    }
}
