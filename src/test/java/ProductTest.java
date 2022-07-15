
import org.junit.jupiter.api.Test;
import ru.netology.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    ProductManager manager = new ProductManager();
    ProductRepository repo = new ProductRepository();
    Book book1 = new Book("Властелин колец", 505, 250, "Дж.Р.Р.Толкин");
    Book book2 = new Book("Хоббит", 510, 400, "Дж.Р.Р.Толкин");
    Smartphone smartphone1 = new Smartphone("Груша", 20, 500, "Яблочный Стив");
    Smartphone smartphone2 = new Smartphone("Игровая подстанция 5", 60, 300, "Кони");

    @Test
    public void test1FindElements() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ин");
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2FindElements() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ша");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3FindElements() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ни");
        Product[] expected = {smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4FindElements() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ив");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test5FindElements() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("а");
        Product[] expected = {book1, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test6FindElements() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("яя");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
    @Test
    void test1Remove() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(505); //Тестируемое действие.

        Product[] actual = repo.findAll();
        Product[] expected = {book2, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test2Remove() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(510);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test3Remove() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(20);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test4Remove() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(60);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test5Remove() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(60);
        repo.removeById(20);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test6Remove() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(505);
        repo.removeById(510);
        repo.removeById(20);
        repo.removeById(60);

        Product[] actual = repo.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test7Remove() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);


    Product[] actual = repo.findAll();
    Product[] expected = {book1, book2, smartphone1, smartphone2};

    assertArrayEquals(expected, actual);
}

    @Test
    void test8FindById() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }

    @Test
    void test9FindById() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(504);
        });
    }
}