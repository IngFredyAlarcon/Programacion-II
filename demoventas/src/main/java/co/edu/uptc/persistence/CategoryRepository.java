package co.edu.uptc.persistence;

import java.util.List;
import com.google.gson.reflect.TypeToken;
import co.edu.uptc.model.Category;

public class CategoryRepository extends JsonRepository<Category> {
    public CategoryRepository() {
        super("src/main/resources/data/categories.json", new TypeToken<List<Category>>() {}.getType());
    }

}
