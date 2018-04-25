package StoreData.dao;

import StoreModel.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mitch
 */
public interface ProductDAO extends JpaRepository<Product, String>{

}