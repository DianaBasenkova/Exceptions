import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    private Product product1 = new Product(1, "FirstProduct", 100);
    private Product product2 = new Product(2, "SecondProduct", 200);
    private Product product3 = new Product(3, "ThirdProduct", 300);
    private Product product4 = new Product(4, "ThirdProduct", 400);

    @Test
    public void shouldSuccessfullyRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1, 1);
        repo.add(product2, 2);
        repo.add(product3, 3);
        repo.remove(1);
        Product[] expected = new Product[]{product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void generateNotFoundException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1, 1);
        repo.add(product2, 2);
        repo.add(product3, 3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(1000);
        });
    }

    @Test
    public void generateAlreadyExistsException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1, 1);
        repo.add(product2, 2);
        repo.add(product3, 3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product4, 1);
        });
    }

    @Test
    public void ShouldAddNewId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1, 1);
        repo.add(product2, 2);
        repo.add(product3, 3);
        repo.add(product4, 4);

        Product[] expected = new Product[]{product1, product2, product3, product4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

}
