package StoreModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mitch
 */
public class ProductService {

    private List<Product> productList = Arrays.asList(
            new Product("A101", "THE SuperJet", 5000000),
            new Product("A101", "THE SuperJet", 5000000),
            new Product("A101", "THE SuperJet", 5000000),
            new Product("A101", "THE SuperJet", 5000000),
            new Product("A101", "THE SuperJet", 5000000),
            new Product("A101", "THE SuperJet", 5000000),
            new Product("A101", "THE SuperJet", 5000000),
            new Product("A101", "THE SuperJet", 5000000),
            new Product("A101", "THE SuperJet", 5000000),
            new Product("A101", "THE SuperJet", 5000000)
    );

    public final Product getProduct(String id) {
        Product product = null;
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                product = p;
            }
        }
        return product;
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
