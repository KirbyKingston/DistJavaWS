package StoreModel;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mitch
 */
public class CartService {

    private List<LineItem> lineItems = Arrays.asList();

    public final List<LineItem> getLineItems() {
        return lineItems;
    }

    public final void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

}
