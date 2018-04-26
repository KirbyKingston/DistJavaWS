package DJStore.data.dao;

import DJStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mitch
 */
public interface IProductDAO extends JpaRepository<Product, String>{

}