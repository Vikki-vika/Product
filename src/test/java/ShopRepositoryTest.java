import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {
    @Test
    public void removeWhenProductExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        Product product3 = new Product(3, "Product 3", 300);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(2);

        Product[] expected = { product1, product3 };
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    //@Test
    public void removeWhenProductDoesNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        Product product3 = new Product(3, "Product 3", 300);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        assertThrows(NotFoundException.class, () -> repo.removeById(4));
    }
}