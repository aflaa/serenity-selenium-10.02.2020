package db;

import org.junit.Before;
import org.junit.Test;
import utils.MySQLDBManager;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utils.MySQLDBManager.tableExists;

public class DBTableManipulationTest {

    @Before
    public void CheckTableExists() throws SQLException, IOException {
        if (tableExists("queries/show_table.sql")) {
            // Table exists
            MySQLDBManager.updateStatement("queries/insert_rows_into_table.sql");
        } else {
            // Table does not exist
            MySQLDBManager.updateStatement("queries/create_table.sql");
            MySQLDBManager.updateStatement("queries/insert_rows_into_table.sql");
        }
    }

    @Test
    public void InsertRowsTest() throws SQLException, IOException {
        int statementResult = MySQLDBManager.updateStatement("queries/insert_rows_into_table.sql");
    }

    @Test
    public void selectFromPetTest() throws SQLException, IOException {
        ResultSet queryResult = MySQLDBManager.executeQuery("queries/select_all_from_table.sql");
    }

    @Test
    public void dropPetTable() throws SQLException, IOException {
        int statementResult = MySQLDBManager.updateStatement("queries/drop_table.sql");
    }

    @Test
    public void updateRowFromPet() throws SQLException, IOException {
        int statementResult = MySQLDBManager.updateStatement("queries/update_table.sql");
    }

    @Test
    public void deleteRowFromPet() throws SQLException, IOException {
        int statementResult = MySQLDBManager.updateStatement("queries/delete_from_table.sql");
    }

}
