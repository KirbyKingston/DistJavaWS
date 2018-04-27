package DJStore.storeData.dao;

import DJStore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mitch
 */
public interface ICartDAO extends JpaRepository<Cart, Integer> {

}
