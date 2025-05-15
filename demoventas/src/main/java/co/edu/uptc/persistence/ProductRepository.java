package co.edu.uptc.persistence;

import java.util.List;
import com.google.gson.reflect.TypeToken;
import co.edu.uptc.model.Product;

public class ProductRepository extends JsonRepository<Product> {
    public ProductRepository() {
        super("src/main/resources/data/products.json", new TypeToken<List<Product>>() {}.getType());
    }
}
