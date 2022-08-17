package ru.netology.productmanager;

import org.junit.jupiter.api.Test;

import javax.naming.NameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(13, "Бесы", 470, "Достоевский");
    Product book2 = new Book(257, "Война и мир", 280, "Толстой");
    Product book3 = new Book(32, "Стихи", 360, "Черный");
    Product book4 = new Book(92, "Стихи", 200, "Белый");
    Product smartphone1 = new Smartphone(47, "Iphone XS", 50_000, "Apple");
    Product smartphone2 = new Smartphone(5, "Galaxy S22 Ultra", 130_000, "Samsung");
    Product smartphone3 = new Smartphone(63, "HONOR 50", 34_000, "HONOR");

    @Test
    public void findProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = { book1, book2, book3, book4, smartphone1, smartphone2, smartphone3 };
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = { book1 };
        Product[] actual = manager.searchBy( "Достоевский");

    }

    @Test
    public void findId() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(book4);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);

        repository.findById(257);

        Product[] expected = { book2 };
        Product[] actual = manager.findAll();
    }

    @Test
    public void findNoId() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(book4);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);

        repository.findById(980);

        Product[] expected = {};
        Product[] actual = manager.findAll();
    }

    @Test
    public void removeId() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(book4);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);

        repository.remove(63);
    }


    @Test
    public void removeNoId() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(book4);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);

        assertThrows(NotFoundException.class, () -> {
            repository.remove(945);
        });
    }

    @Test
    public void searchNameProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = { book2 };
        Product[] actual = manager.searchBy("Война и мир");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNoSmartphone() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("HUAWEI");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNoBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Преступление и наказание");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSameName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = { book3, book4 };
        Product[] actual = manager.searchBy("Стихи");

        assertArrayEquals(expected, actual);
    }
}