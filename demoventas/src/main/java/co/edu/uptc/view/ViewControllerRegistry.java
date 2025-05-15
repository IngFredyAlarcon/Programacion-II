package co.edu.uptc.view;

import co.edu.uptc.view.ProductViewController;

public class ViewControllerRegistry {
    private static ProductViewController productViewController;

    public static void registerProductViewController(ProductViewController controller) {
        productViewController = controller;
    }

    public static ProductViewController getProductViewController() {
        return productViewController;
    }
}
