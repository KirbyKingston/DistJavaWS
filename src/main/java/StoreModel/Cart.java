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

    private final List<Product> contents = new ArrayList<>();

    public final List<Product> getContents() {
        return contents;
    }

    public final int getItemsInCart() {
        return contents.size();
    }

    public final void add(Product product) {
        contents.add(product);
    }

    public final void remove(Product product) {
        contents.remove(product);
    }

    public final void removeAll() {
        contents.clear();
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.contents);
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
        if (!Objects.equals(this.contents, other.contents)) {
            return false;
        }
        return true;
    }

    @Override
    public final String toString() {
        return "Cart{" + "contents=" + contents + '}';
    }

}
