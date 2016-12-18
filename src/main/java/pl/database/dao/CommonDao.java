package pl.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import pl.database.manager.DbManager;
import pl.database.models.Model;

import java.sql.SQLException;

/**
 * Created by davit on 11.12.2016.
 */
public class CommonDao {

    public static <T> Model createOrUpdate(Class<T> cls, final Model model) {
        try {
            Dao<Model, Integer> createDao = (Dao<Model, Integer>) getDao(cls);
            createDao.createOrUpdate(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public static <T> void refresh(Class<T> cls, final Model model) {
        try {
            Dao<Model, Integer> createDao = (Dao<Model, Integer>) getDao(cls);
            createDao.refresh(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static <T> T queryForId(final Class<T> cls, Integer id) {
        try {
            Dao<T, Integer> createDao = (Dao<T, Integer>) getDao(cls);
            return createDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> Dao<T, T> getDao(Class<T> cls) {
        try {
            return DaoManager.createDao(DbManager.getInstance().getConnectionSource(), cls);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
