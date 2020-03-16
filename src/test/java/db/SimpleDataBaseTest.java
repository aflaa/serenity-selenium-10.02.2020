package db;

import org.junit.Test;
import utils.MySQLDBManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SimpleDataBaseTest {
    @Test
    public void selectFromPetTest() throws SQLException, IOException {

        //MySQLDBManager mySQLDBManager = new MySQLDBManager();

        MySQLDBManager.executeQuery("queries/select_all_from_pet.sql");

        //ResultSet rs;//=stmt.executeQuery("Select 1 from dual;");

        //System.out.println("1st rs: " + rs);
//
//        String sql = "INSERT INTO pet   VALUES ('May','Diane','hamster','f','20-02-20',NULL);";
//        long executeUpdate = statement.executeUpdate(sql);
//        //rs = insertRowToPet(stmt).getResultSet();
//        System.out.println(executeUpdate);
//
//        rs = selectFromPet(statement);
//        System.out.println("rs: " + rs);
//
//
//        ArrayList<String> arr = new ArrayList<String>();
//        while (rs.next()) {
//            arr.add(rs.getString("name"));
//            System.out.println(arr.get(arr.size() - 1));
//        }
//
//        System.out.println(rs.toString());


    }

    private Statement createPet(Statement stmt) throws SQLException {
        String sql = "CREATE TABLE pet (name VARCHAR(20), owner VARCHAR(20),\n" +
                "       species VARCHAR(20), sex CHAR(1), birth DATE, death DATE);";
        long executeUpdate = stmt.executeLargeUpdate(sql);
        return stmt;
    }

    private Statement insertRowToPet(Statement stmt) throws SQLException {
        String sql = "INSERT INTO pet   VALUES ('May','Diane','hamster','f','20-02-20',NULL);";
        long executeUpdate = stmt.executeUpdate(sql);
        return stmt;
    }

    private Statement dropPetTable(Statement stmt) throws SQLException {
        String sql = "Drop table pet;";
        long executeUpdate = stmt.executeUpdate(sql);
        return stmt;
    }

    private Statement updateRowFromPet(Statement stmt) throws SQLException {
        String sql = "update pet set owner='Jake' where name='may';";
        long executeUpdate = stmt.executeUpdate(sql);
        return stmt;
    }

    private Statement deleteRowFromPet(Statement stmt) throws SQLException {
        String sql = "DELETE FROM pet where name='may';";
        long executeUpdate = stmt.executeUpdate(sql);
        return stmt;
    }

    private ResultSet selectFromPet(Statement stmt) throws SQLException {
        String sql = "Select * from pet;";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

}
