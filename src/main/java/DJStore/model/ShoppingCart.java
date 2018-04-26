package DJStore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mitch
 */

public class ShoppingCart implements Serializable {
	private final List<Product> contents = new ArrayList<>();

	public List<Product> getContents() {
		return contents;
	}

	public int getItemsInCart() {
		return contents.size();
	}

	public void add(Product p) {
		contents.add(p);
	}

	public void remove(Product p) {
		contents.remove(p);
	}

	public void removeAll() {
		contents.clear();
	}

}
