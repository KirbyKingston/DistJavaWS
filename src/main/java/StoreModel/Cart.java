package StoreModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mitch
 */
public class Cart {

    private final List<Product> cartItems = new ArrayList<>();

    public final List<Product> getCartItems() {
        return cartItems;
    }

    public final int getItemsInCart() {
        return cartItems.size();
    }

    public final void add(Product product) {
        cartItems.add(product);
    }

    public final void remove(Product product) {
        cartItems.remove(product);
    }

    public final void removeAll() {
        cartItems.clear();
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.cartItems);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cart other = (Cart) obj;
        if (!Objects.equals(this.cartItems, other.cartItems)) {
            return false;
        }
        return true;
    }

    @Override
    public final String toString() {
        return "Cart{" + "contents=" + cartItems + '}';
    }

}
