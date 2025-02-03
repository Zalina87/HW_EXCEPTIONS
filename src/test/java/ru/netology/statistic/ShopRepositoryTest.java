package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    void add() {
        Product product1 = new Product(1, "молоко", 25);
        Product product2 = new Product(2, "хлеб", 15);
        Product product3 = new Product(3, "яйца", 30);

        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(product1);


        });
    }

    @Test
    void findAll() {
        Product product1 = new Product(1, "молоко", 25);
        Product product2 = new Product(2, "хлеб", 15);
        Product product3 = new Product(3, "яйца", 30);

        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        Product[] expected = {product1, product2, product3};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void remove() {
        Product product1 = new Product(1, "молоко", 25);
        Product product2 = new Product(2, "хлеб", 15);
        Product product3 = new Product(3, "яйца", 30);

        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.remove(1);
        Product[] expected = {product2, product3};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        Product product1 = new Product(1, "молоко", 25);

        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);

        Product expected = product1;
        Product actual = shopRepository.findById(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        Product product1 = new Product(1, "молоко", 25);
        Product product2 = new Product(2, "хлеб", 15);
        Product product3 = new Product(3, "яйца", 30);

        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(-100);


        });

    }
}