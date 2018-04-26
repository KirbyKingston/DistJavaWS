package DJStore.service;

import DJStore.model.ShoppingCart;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mitch
 */
@Service
@Transactional
public class ShoppingCartService {

	private static final Map<String, ShoppingCart> contents = new HashMap<>();

	public ShoppingCart getContents(String sessionId) {
		ShoppingCart cart = contents.computeIfAbsent(sessionId,
			(String t) -> new ShoppingCart());

//		ShoppingCart cart = contents.computeIfAbsent(sessionId,
//			new Function<String, ShoppingCart>() {
//			@Override
//			public ShoppingCart apply(String t) {
//				return new ShoppingCart();
//			}
//		});
		return cart;
	}

	public void update(String sessionId, ShoppingCart cart) {
		contents.put(sessionId, cart);	
	}

	public void delete(String sessionId) {
		contents.remove(sessionId);
	}

}
