package org.justinhoang.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/** The type Database. */
public class Database {

    private final Logger logger = LogManager.getLogger(this.getClass());
    // create an object of the class Database
    private static final Database instance = new Database();

    private Properties properties;
    private Connection connection;

    // private constructor prevents instantiating this class anywhere else
    private Database() {
        loadProperties();

    }

    // load properties
    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file");
        } catch (Exception e) {
            logger.error("Database.loadProperties()..." + e);
        }

    }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  // get the only Database object available
  public static Database getInstance() {
        return instance;
    }

  /**
   * Gets connection.
   *
   * @return the connection
   */
  public Connection getConnection() {
        return connection;
    }

  /**
   * Connect.
   *
   * @throws Exception the exception
   */
  public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("Database.connect()... Error: MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"),  properties.getProperty("password"));
    }

  /** Disconnect. */
  public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Cannot close connection" + e);
            }
        }

        connection = null;
    }

  /**
   * Run the sql.
   *
   * @param sqlFile the sql file to be read and executed line by line
   */
  public void runSQL(String sqlFile) {

        Statement stmt = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(classloader.getResourceAsStream(sqlFile))))  {

            connect();
            stmt = connection.createStatement();

            StringBuilder sql;
            sql = new StringBuilder();
            while (br.ready())
            {
                char inputValue = (char)br.read();

                if(inputValue == ';')
                {
                    stmt.executeUpdate(sql.toString());
                    sql = new StringBuilder();
                }
                else
                    sql.append(inputValue);
            }

        } catch (Exception se) {
            logger.error(se);
        } finally {
            disconnect();
        }

    }
}
