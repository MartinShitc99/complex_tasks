package test.java.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryService {
    private boolean isOpen = false;
    private Map<String, List<Product>> shelves = new HashMap<>();

    public void openInventory(boolean isOpen) {
        this.isOpen = isOpen;
        return;
    }

    public void addProduct(Product product) {
        if (!this.isOpen) {
            System.out.println("Склад закрыт");
            return;
        }

        String cat = product.getCategory();

        List<Product> list = shelves.computeIfAbsent(cat, k -> new ArrayList<>());
        list.add(product);
    }

    public List<Product> getProducts(String category) {
        List<Product> list = shelves.get(category);
        if (list == null || list.isEmpty()) {
            throw new OutOfStockException("Товара нет");
        }
        return list;
    }

    public List<Product> filterByPrice(String category, double maxPrice) {
        List<Product> products = this.getProducts(category);
        return products.stream()
                .filter(product -> product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}
