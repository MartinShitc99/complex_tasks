package test.java;

import org.junit.jupiter.api.Test;
import practice_9.streamapi.FilterList;
import test.java.ProductService.InventoryService;
import test.java.ProductService.OutOfStockException;
import test.java.ProductService.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryServiceTest {
    private InventoryService service = new InventoryService();

    @Test
    public void InventoryServiceTest() {
        service.openInventory(true);

        assertThrows(OutOfStockException.class, () -> {
            service.getProducts("Категория");
        });
    }

    @Test
    public void testFilterByPrice() {
        service.openInventory(true);
        Product p1 = new Product("iPhone 17 pro", 1000.0, "Телефон");
        Product p2 = new Product("Мыло", 200.0, "Хозтовары");
        service.addProduct(p1);
        service.addProduct(p2);
        List<Product> result = service.filterByPrice("Хозтовары", 200);
        assertEquals(1, result.size());
    }
}
