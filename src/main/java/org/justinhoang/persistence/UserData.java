package org.justinhoang.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.User;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM user";
        logger.info("Here's the select sql " + sql);

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException sqle) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: ", sqle);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: ", e);
        }
        return users;
    }

    public List<User> getUserById(int id) {
        String sql = "SELECT * FROM user WHERE id like '%" + id + "%'";
        logger.info("Here's the select sql " + sql);
        return executeQuery(sql);
    }

    public List<User> getUserByFirstName(String firstName) {
        String sql = "SELECT * FROM user WHERE first_name like '%" + firstName +
                "%'";
        logger.info("Here's the select sql " + sql);
        return executeQuery(sql);
    }

    public List<User> getUserByLastName(String lastName) {
        String sql = "SELECT * FROM user WHERE last_name like '%" + lastName +
                "%'";
        logger.info("Here's the select sql " + sql);
        return executeQuery(sql);
    }

    public List<User> getUserByUserName(String userName) {
        String sql = "SELECT * FROM user WHERE user_name like '%" + userName +
                "%'";
        logger.info("Here's the select sql " + sql);
        return executeQuery(sql);
    }

    public List<User> getUserByBirthdate(LocalDate birthdate) {
        String sql =
                "SELECT * FROM user WHERE date_of_birth like '%" + birthdate +
                        "%'";
        logger.info("Here's the select sql " + sql);
        return executeQuery(sql);
    }

    public List<User> executeQuery(String sql) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException sqle) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: ", sqle);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: ", e);
        }
        return users;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setId(Integer.parseInt(results.getString("id")));
        user.setFirstName(results.getString("first_name"));
        user.setLastName(results.getString("last_name"));
        user.setEmail(results.getString("email"));
        user.setUsername(results.getString("username"));
        return user;
    }

}
