import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    private Product product1 = new Product(1, "FirstProduct", 100);
    private Product product2 = new Product(2, "SecondProduct", 200);
    private Product product3 = new Product(3, "ThirdProduct", 300);

    @Test
    public void shouldSuccessfullyRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);
        Product[] expected = new Product[]{product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void generateNotFoundException() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "FirstProduct", 100));
        repo.add(new Product(2, "SecondProduct", 200));
        repo.add(new Product(3, "ThirdProduct", 300));

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(1000);
        });
    }
}
