package DJStore.data.dao;

import DJStore.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mitch
 */
public interface ICartDAO extends JpaRepository<ShoppingCart, Integer> {

}
