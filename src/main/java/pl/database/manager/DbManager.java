package pl.database.manager;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.database.models.Author;
import pl.database.models.Book;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by davit on 10.12.2016.
 */
public class DbManager {

    private static final String JDBC_DRIVER = "jdbc:sqlite:";
    private static final String PATH = "src/main/resources/database";
    private static final String DB_NAME = "/database.db";
    private static final String USER = "admin1";
    private static final String PASS = "admin1";


    private static ConnectionSource connectionSource;


    private static DbManager dbManager;

    public synchronized static DbManager getInstance() {
        if (dbManager == null) {
            dbManager = new DbManager();
        }
        return dbManager;
    }

    public static void initDatabase() {
        createConnection();
        dropTable();
        createTable();
    }

    private static void createConnection() {
        try {
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER + PATH + DB_NAME,USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable() {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Book.class);
            TableUtils.createTableIfNotExists(connectionSource, Author.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropTable() {
        try {
            TableUtils.dropTable(connectionSource, Book.class, true);
            TableUtils.dropTable(connectionSource, Author.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public static void closeConnection() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
