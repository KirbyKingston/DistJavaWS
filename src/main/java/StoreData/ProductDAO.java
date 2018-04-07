package StoreData;

import StoreModel.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mitch
 */
public class ProductDAO {

    public final List<Product> getProducts() throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionUtil.getConnection();
            stmt = conn.prepareStatement("select * from PRODUCT");
            rs = stmt.executeQuery();

            List<Product> productList = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("id");
                String description = rs.getString("description");
                double unitCost = rs.getDouble("unitCost");

                Product product = new Product(id, description, unitCost);

                productList.add(product);
            }
            return productList;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
