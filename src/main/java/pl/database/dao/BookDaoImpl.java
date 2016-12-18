package pl.database.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import pl.database.models.Book;

import java.sql.SQLException;

/**
 * Created by davit on 11.12.2016.
 */
public class BookDaoImpl extends BaseDaoImpl<Book, Integer> implements BookDao {

    public BookDaoImpl(ConnectionSource connectionSource, Class<Book> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    @Override
    public int create(Book data) throws SQLException {
        System.out.println("TRATRTRTRRTRTRTTR");
        return super.create(data);
    }
}
