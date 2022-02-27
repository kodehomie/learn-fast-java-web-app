package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class to run sql statements as part of set up or tear down in the unit tests.
 */
public class DbUtil {

    private final Logger logger = LogManager.getLogger(this.getClass());


    static final String DB_HOST = "jdbc:mysql://localhost/learnfasttest";

    static final String DB_USER = "root";

    static final String DB_PASSWORD = "root";


    /**
     * Run the sql.
     *
     * @param sqlFile the sql file to be read and executed line by line
     */
    public void runSQL(String sqlFile) {
        Connection conn = null;
        Statement stmt = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(sqlFile);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD);

            stmt = conn.createStatement();

            while (true) {
                String sql = br.readLine();
                if (sql == null) {
                    break;
                }
                stmt.executeUpdate(sql);

            }

        } catch (SQLException se) {
            logger.error(se);
        } catch (Exception e) {
            logger.error(e);
        }

    }
}
