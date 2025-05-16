package co.edu.uptc.view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import co.edu.uptc.controller.*;
import co.edu.uptc.model.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

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
    @FXML
    private ImageView productImageView;
    @FXML
    private TilePane productTilePane;

    private File imageSelected;

    private final ProductController productController = new ProductController();
    private final CategoryController categoryController = new CategoryController();

    @FXML
    public void initialize() {
        loadProducts();
        ViewControllerRegistry.registerProductViewController(this);
        productTable.setItems(productController.getProducts());
        System.out.println("Categorías cargadas: " + categoryController.getCategories());

        categoryComboBox.setItems(categoryController.getCategories());

        nameCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getName()));
        priceCol.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().getPrice()));
        categoryCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getCategory().getName()));
    }

    @FXML
    public void selectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen del producto");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            imageSelected = file;
            Image image = new Image(file.toURI().toString());
            productImageView.setImage(image);
        }
    }

    @FXML
    private void handleAddProduct() {
        try {
            String name = productName.getText();
            double price = Double.parseDouble(productPrice.getText());
            Category category = categoryComboBox.getValue();

            if (name.isEmpty() || category == null)
                return;

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setCategory(category);
            if (imageSelected != null) {
                String destino = "src\\main\\resources\\images\\" + imageSelected.getName();
                try {
                    Files.copy(imageSelected.toPath(), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
                    product.setImagePath(destino);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

    public void loadProducts() {
        for (Product p : productController.getProducts()) {
            VBox card = new VBox(5);
            card.setPadding(new Insets(10));
            card.setStyle(
                    "-fx-border-color: gray; -fx-background-color: white; -fx-border-radius: 10; -fx-background-radius: 10;");

            if (p.getImagePath() != null && !p.getImagePath().isEmpty()) {
                File imgFile = new File(p.getImagePath());
                if (imgFile.exists()) {
                    Image image = new Image(imgFile.toURI().toString(), 100, 100, true, true);
                    ImageView imageView = new ImageView(image);
                    card.getChildren().add(imageView);
                }
            }

            Label nombre = new Label(p.getName());
            Label precio = new Label("Cantidad: " + p.getStock());

            card.getChildren().addAll(nombre, precio);
            productTilePane.getChildren().add(card);
        }
    }

}
