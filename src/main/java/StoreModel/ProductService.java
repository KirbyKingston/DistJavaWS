package StoreModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import StoreData.ProductDAO;


/**
 *
 * @author Mitch
 */
public class ProductService {

//    private final List<Product> productList = Arrays.asList(
//            new Product("A101", "THE SuperJet", 5000000),
//            new Product("A102", "THE SuperJet", 5000000),
//            new Product("A103", "THE SuperJet", 5000000),
//            new Product("A104", "THE SuperJet", 5000000),
//            new Product("A105", "THE SuperJet", 5000000),
//            new Product("A106", "THE SuperJet", 5000000),
//            new Product("A107", "THE SuperJet", 5000000),
//            new Product("A108", "THE SuperJet", 5000000),
//            new Product("A109", "THE SuperJet", 5000000),
//            new Product("A110", "THE SuperJet", 5000000)
//    );

    ProductDAO pdSource = new ProductDAO();
    private List<Product> productList;
    productList= pdSource.getProducts();
    
    public Product getProduct(String sId) {
        if (sId != null) {
            for (Product p : productList) {
                if (p.getId().equals(sId)) {
                    return p;
                }
            }

        }
        return null;
    }

    public final List<Product> getAllProducts() {
        return productList;
    }

    public final List<Product> findProducts(String search) {
        search = search.toLowerCase();
        List<Product> list = new ArrayList<>();
        for (Product product : productList) {
            if (product.getId().toLowerCase().contains(search)
                    || product.getDescription().toLowerCase().contains(search)) {
                list.add(product);
            }
        }
        return list;
    }
}
