package utils;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLDBManager {

    private MySQLDBManager() { // private
    }

    private final static String USER_NAME = "92JgseRu78";
    private final static String USER_PASSWORD = "Gq8QccN8Eb";
    private final static String SERVER_NAME = "remotemysql.com";
    private final static int SERVER_PORT = 3306;
    private final static String DB_NAME = USER_NAME;

    private static Connection createConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(USER_NAME);
        dataSource.setPassword(USER_PASSWORD);
        dataSource.setServerName(SERVER_NAME);
        dataSource.setPort(SERVER_PORT);
        dataSource.setDatabaseName(DB_NAME);

        return dataSource.getConnection();
    }

    private static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private static String getQueryFromFile(String filePath) throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }


    public static ResultSet executeQuery(String filePath) throws SQLException, IOException {
        Connection connection = createConnection();
        String query = getQueryFromFile(filePath);
        //stmt.executeLargeUpdate("CREATE TABLE pet (name VARCHAR(20), owner VARCHAR(20), species VARCHAR(20), sex CHAR(1), birth DATE, death DATE);");
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        queryResult(resultSet);
        closeConnection(connection);
        return resultSet;
    }

    public static boolean tableExists(String filePath) throws SQLException, IOException {
        Connection connection = createConnection();
        String query = getQueryFromFile(filePath);
        boolean tableExist = connection.createStatement().executeQuery(query).next();
        closeConnection(connection);
        return tableExist;
    }


    public static int updateStatement(String filePath) throws SQLException, IOException {
        Connection connection = createConnection();
        String query = getQueryFromFile(filePath);
        int resultSet = connection.createStatement().executeUpdate(query);
        System.out.println("Statement returns: " + resultSet);
        closeConnection(connection);
        return resultSet;
    }

    private static ArrayList<String[]> queryResult(ResultSet rs) throws SQLException {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int columnCount = rs.getMetaData().getColumnCount();
        int rowCount = 0;
        String resultRow = "";
        while (rs.next()) {
            String[] row = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = rs.getString(i + 1);
                resultRow = resultRow.concat(row[i] + " ");
            }
            System.out.println("row is " + resultRow);
            resultRow = "";
            result.add(row);
            rowCount = rowCount + 1;
        }
        System.out.println("row count is " + rowCount);
        return result;
    }
}