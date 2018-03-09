package StoreModel;

import java.util.Objects;

/**
 *
 * @author Mitch
 */
public class LineItem {

    public final static String REQUIRED_MSG = "This is an invalid value.";

    private Product product;
    private int qty;
    private double lineItemSubtotal;

    public LineItem(Product product, int qty) {
        setProduct(product);
        setQty(qty);
        lineItemSubtotal = getCostBeforeDiscountLineTotal();
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        this.product = product;
    }

//    public final String displayLineItem() {
//        return (product.getDescription() + product.getUnitCost() + getDiscountAmt() + getDiscountAmtLineTotal() + getYouSavedLineTotal());
//    }
    public final double getCostBeforeDiscount() {
        return product.getUnitCost();
    }

    public final double getCostBeforeDiscountLineTotal() {
        return product.getUnitCost() * qty;
    }

//    public final double getDiscountAmt() {
//        return product.getDiscountStrategy().getDiscountAmt(product.getUnitCost(), qty);
//    }
//
//    public final double getDiscountAmtLineTotal() {
//        return getDiscountAmt() * qty;
//    }
//
//    public final double getYouSavedLineTotal() {
//        return getCostBeforeDiscountLineTotal() - getDiscountAmtLineTotal();
//    }
    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException(REQUIRED_MSG);
        }
        this.qty = qty;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.product);
        hash = 13 * hash + this.qty;
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
        final LineItem other = (LineItem) obj;
        if (this.qty != other.qty) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    @Override
    public final String toString() {
        return "LineItem{" + "product=" + product + ", qty=" + qty + '}';
    }

}
