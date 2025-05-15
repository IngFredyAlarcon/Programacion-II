package co.edu.uptc.view;

import co.edu.uptc.controller.*;
import co.edu.uptc.model.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProductViewController {

    @FXML
    private TextField productName;
    @FXML
    private TextField productPrice;
    @FXML
    private ComboBox<Category> categoryComboBox;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> nameCol;
    @FXML
    private TableColumn<Product, Double> priceCol;
    @FXML
    private TableColumn<Product, String> categoryCol;

    private final ProductController productController = new ProductController();
    private final CategoryController categoryController = new CategoryController();

    @FXML
    public void initialize() {
        ViewControllerRegistry.registerProductViewController(this);
        productTable.setItems(productController.getProducts());
        System.out.println("Categorías cargadas: " + categoryController.getCategories());

        categoryComboBox.setItems(categoryController.getCategories());

        nameCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getName()));
        priceCol.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().getPrice()));
        categoryCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getCategory().getName()));
    }

    @FXML
    private void handleAddProduct() {
        try {
            String name = productName.getText();
            double price = Double.parseDouble(productPrice.getText());
            Category category = categoryComboBox.getValue();

            if (name.isEmpty() || category == null)
                return;

            Product product = new Product(0, name, "", price, 0, category);
            productController.addProduct(product);

            productName.clear();
            productPrice.clear();
            categoryComboBox.getSelectionModel().clearSelection();
        } catch (NumberFormatException e) {
            System.out.println("Precio inválido.");
        }
    }

    public void refresh() {
        categoryComboBox.setItems(AppContext.getCategoryController().getCategories());
    }
}
