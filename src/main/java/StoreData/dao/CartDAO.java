package StoreData.dao;

import StoreModel.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mitch
 */
public interface CartDAO extends JpaRepository<Cart, Integer> {

}
