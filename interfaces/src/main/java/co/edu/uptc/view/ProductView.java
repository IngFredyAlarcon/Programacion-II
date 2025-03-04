package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.controller.ProductController;

public class ProductView {
    Scanner scanner = new Scanner(System.in);

    public ProductController productController = new ProductController();

    public void createProduct() {
        scanner.nextLine();
        System.out.println("Enter the name of the product: ");
        String name = scanner.nextLine();
        System.out.println("Enter the description of the product: ");
        String description = scanner.nextLine();
        System.out.println("Enter the price of the product: ");
        double price = scanner.nextDouble();
        System.out.println("Enter the stock of the product: ");
        int stock = scanner.nextInt();
        if (productController.createProduct(name, description, price, stock)) {
            System.out.println("Product created successfully");
        } else {
            System.out.println("Error creating the product");
        }
    }

    public void updateProduct() {
        scanner.nextLine();
        System.out.println("Enter the name of the product: ");
        String name = scanner.nextLine();
        System.out.println("Enter the description of the product: ");
        String description = scanner.nextLine();
        System.out.println("Enter the price of the product: ");
        double price = scanner.nextDouble();
        System.out.println("Enter the stock of the product: ");
        int stock = scanner.nextInt();
        if (productController.updateProduct(name, description, price, stock)) {
            System.out.println("Product updated successfully");
        } else {
            System.out.println("Error updating the product");
        }
    }

    public void deleteProduct() {
        if (productController.deleteProduct()) {
            System.out.println("Product deleted successfully");
        } else {
            System.out.println("Error deleting the product");
        }
    }

    public void listProducts() {
        
        productController.listProducts().forEach(product -> {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Stock: " + product.getStock());
        });
    }

    public void showMenu() {
        int option = 0;
        do {
            System.out.println("1. Create product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. List products");
            System.out.println("5. Exit");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    listProducts();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 5);
    }

    public static void main(String[] args) {
        ProductView productView = new ProductView();
        productView.showMenu();
    }
}
