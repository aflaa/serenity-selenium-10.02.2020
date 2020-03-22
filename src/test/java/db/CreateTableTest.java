package db;

import org.junit.Before;
import org.junit.Test;
import utils.MySQLDBManager;

import java.io.IOException;
import java.sql.SQLException;

import static utils.MySQLDBManager.tableExists;

public class CreateTableTest {
    boolean tableExist = true;


    @Before
    public void CheckTableExists() throws SQLException, IOException {
        if (tableExists("queries/show_table.sql")) {
            // Table exists
            MySQLDBManager.updateStatement("queries/drop_table.sql");
        }
    }

    @Test
    public void CreateTableTest() throws SQLException, IOException {
        int queryResult = MySQLDBManager.updateStatement("queries/create_table.sql");
    }
}
