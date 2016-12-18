package pl.database;

import pl.database.dao.CommonDao;
import pl.database.manager.DbManager;
import pl.database.models.Author;
import pl.database.models.Book;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by davit on 10.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        DbManager.getInstance().initDatabase();

        Author author1 = new Author();
        author1.setName("Tolkien");
        Book book1 = new Book();
        book1.setAuthor(author1);
        book1.setTittle("Władca pierścieni");
        book1.setIsbn("11111");
        book1.setDateRelease(LocalDate.now());
        book1.setRating(1);
        book1.setAddedDate(new Date());

        CommonDao.createOrUpdate(Book.class, book1);
        CommonDao.refresh(Author.class, author1);

        System.out.println("Wypisuję book1 po zapisie: " + book1);


        Book updatedBook = CommonDao.queryForId(Book.class, new Integer(1));
        updatedBook.setTittle("Hobbit");
        CommonDao.createOrUpdate(Book.class, updatedBook);
        System.out.println("Wypisuję book1 po update: " + updatedBook);

        DbManager.getInstance().closeConnection();

    }


}
