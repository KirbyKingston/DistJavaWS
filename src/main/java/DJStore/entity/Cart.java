package DJStore.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mitch
 */
@Entity
@Table(name = "CART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
    , @NamedQuery(name = "Cart.findByCartid", query = "SELECT c FROM Cart c WHERE c.cartid = :cartid")
    , @NamedQuery(name = "Cart.findByCartqty", query = "SELECT c FROM Cart c WHERE c.cartqty = :cartqty")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CARTID")
    private Integer cartId;
    @Column(name = "CARTQTY")
    private Integer cartQty;
    @JoinColumn(name = "FKCUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne
    private Customer fkcustomerid;
    @JoinColumn(name = "FKPRODUCTID", referencedColumnName = "PRODUCTID")
    @ManyToOne
    private Product fkproductid;

    public Cart() {
    }

    public Cart(Integer cartid) {
        this.cartId = cartid;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartQty() {
        return cartQty;
    }

    public void setCartQty(Integer cartQty) {
        this.cartQty = cartQty;
    }

    public Customer getFkcustomerid() {
        return fkcustomerid;
    }

    public void setFkcustomerid(Customer fkcustomerid) {
        this.fkcustomerid = fkcustomerid;
    }

    public Product getFkproductid() {
        return fkproductid;
    }

    public void setFkproductid(Product fkproductid) {
        this.fkproductid = fkproductid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DJStore.model.Cart[ cartid=" + cartId + " ]";
    }
    
}
