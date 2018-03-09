package StoreModel;

import java.util.Objects;

/**
 *
 * @author Mitch
 */
public class Product {

    public final static String REQUIRED_MSG = "This is a required field.";

    private String id;
    private String description;
    private double unitCost;

    public Product(String id, String description, double unitCost) {
        setId(id);
        setDescription(description);
        setUnitCost(unitCost);
    }

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException(REQUIRED_MSG);
        }
        this.id = id;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException(REQUIRED_MSG);
        }
        this.description = description;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        if (unitCost < 0) {
            throw new IllegalArgumentException(REQUIRED_MSG);
        }
        this.unitCost = unitCost;
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public final String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", unitCost=" + unitCost + '}';
    }

}
