package DJStore.service;

import DJStore.data.dao.IProductDAO;
import DJStore.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mitch
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    private IProductDAO pDAO;

    public Product getProductById(String searchId) {
        return pDAO.getOne(searchId);
    }

    public List<Product> getAllProducts() {
        return pDAO.findAll();
    }

    public List<Product> findProducts(String search) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("description", startsWith().ignoreCase());
        Product p = new Product();
        p.setDescription(search);
        return pDAO.findAll(Example.of(p, matcher));
    }

}
