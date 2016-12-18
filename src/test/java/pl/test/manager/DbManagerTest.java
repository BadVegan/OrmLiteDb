package pl.test.manager;

import org.junit.Before;
import org.junit.Test;
import pl.database.manager.DbManager;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by davit on 11.12.2016.
 */
public class DbManagerTest {


    @Before
    public void getSingletonInstance() {

    }

    @Test
    public void testSingletonInstance() {
        DbManager dbManager = DbManager.getInstance();
        assertTrue(dbManager == DbManager.getInstance());
    }

}