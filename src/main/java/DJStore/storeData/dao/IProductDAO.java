package DJStore.storeData.dao;

import DJStore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mitch
 */
public interface IProductDAO extends JpaRepository<Product, String>{

}