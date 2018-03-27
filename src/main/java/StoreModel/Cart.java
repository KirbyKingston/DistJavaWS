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
    
    public List<Product> getContents(){
        return contents;
    }

    public int getItemsInCart(){
        return contents.size();
    }

    public void add(Product product){
        contents.add(product);
    }

    public void remove(Product product){
        contents.remove(product);
    }

    public void removeAll(){
        contents.clear();
    }

    
}
