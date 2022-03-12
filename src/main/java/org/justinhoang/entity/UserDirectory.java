package org.justinhoang.entity;

import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class UserDirectory
{

    private Properties properties;

    public UserDirectory()
    {
    }

    public UserDirectory(Properties properties)
    {
        this();
        this.properties = properties;
    }

    private Connection connectToDatabase()
    {
        Connection connection = null;
        try
        {
            Class.forName(properties.getProperty("driver"));
            connection =
                    DriverManager.getConnection(properties.getProperty("url"),
                                                properties.getProperty(
                                                        "username"),
                                                properties.getProperty(
                                                        "password"));
        }
        catch (ClassNotFoundException classNotFound)
        {
            classNotFound.printStackTrace();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        catch (Exception exception)
        {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        return connection;
    }

    public void addUserRecord(Date birthdate, String firstName,
                              String lastName, String email, String phone,
                              String username, String password)
    {
        Connection        connection        = null;
        Statement         statement         = null;
        PreparedStatement preparedStatement = null;
        ResultSet         resultSet         = null;
        int               rowsAffected      = 0;
        try
        {
            connection        = connectToDatabase();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO" + " user " + "(birthdate, first_name, " +
                    "last_name, email," + " phone, username, password)" +
                    " VALUES (" + "'" + birthdate + "'" + ", " + "'" +
                    firstName + "'" + ", " + "'" + lastName + "'" + ", " + "'" +
                    email + "'" + ", " + "'" + phone + "'" + ", " + "'" +
                    username + "'" + ", " + "'" + password + "'" + ");");
            rowsAffected      = preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        catch (Exception exception)
        {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (statement != null)
                {
                    statement.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    public Search searchUserDatabase(Search search)
    {
        if (search.getEnteredSearchType().equals("ID"))
        {
            searchByUserID(search);
        }
        else if (search.getEnteredSearchType().equals("lastName"))
        {
            searchByLastName(search);
        }
        else
        {
            searchByFirstName(search);
        }
        return search;
    }

    private void searchByUserID(Search search)
    {
        Connection        connection        = null;
        Statement         statement         = null;
        PreparedStatement preparedStatement = null;
        ResultSet         resultSet         = null;
        search.setIsUserFound(false);
        try
        {
            connection = connectToDatabase();
            String enteredSearchTerm = search.getEnteredSearchTerm();
            preparedStatement = connection.prepareStatement(
                    "SELECT id, " + "birthdate, " + "first_name, " +
                    "last_name, email, phone, username " + " FROM " + " user " +
                    "WHERE id = " + enteredSearchTerm + ";");
            resultSet         = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String userID    = resultSet.getString("id");
                String firstName = resultSet.getString("first_name");
                String lastName  = resultSet.getString("last_name");
                User   user      = new User();
                user.setId(Long.valueOf(resultSet.getString("id")));
                user.setFirstName(resultSet.getString("birthdate"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setUsername(resultSet.getString("username"));
                search.addFoundUser(user);
                search.setIsUserFound(true);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        catch (Exception exception)
        {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (statement != null)
                {
                    statement.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    private void searchByLastName(Search search)
    {
        Connection        connection        = null;
        Statement         statement         = null;
        PreparedStatement preparedStatement = null;
        ResultSet         resultSet         = null;
        search.setIsUserFound(false);
        try
        {
            connection = connectToDatabase();
            statement  = connection.createStatement();
            String enteredSearchTerm = search.getEnteredSearchTerm().trim();
            preparedStatement = connection.prepareStatement(
                    "SELECT id, " + "birthdate, " + "first_name, " +
                    "last_name, email, phone, username " + " FROM " + "user " +
                    "WHERE last_name " + "like '" + enteredSearchTerm + "%';");
            resultSet         = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String userID    = resultSet.getString("id");
                String firstName = resultSet.getString("first_name");
                String lastName  = resultSet.getString("last_name");
                User   user      = new User();
                user.setId(Long.valueOf(resultSet.getString("id")));
                user.setFirstName(resultSet.getString("birthdate"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setUsername(resultSet.getString("username"));
                search.addFoundUser(user);
                search.setIsUserFound(true);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        catch (Exception exception)
        {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (statement != null)
                {
                    statement.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    /**
     * This instance method, "searchByFirstName", searches the database by first
     * name.
     *
     * @param search
     *         Search representing a search.
     */
    private void searchByFirstName(Search search)
    {
        Connection        connection        = null;
        PreparedStatement preparedStatement = null;
        Statement         statement         = null;
        ResultSet         resultSet         = null;
        search.setIsUserFound(false);
        try
        {
            connection = connectToDatabase();
            statement  = connection.createStatement();
            String enteredSearchTerm = search.getEnteredSearchTerm().trim();
            preparedStatement = connection.prepareStatement(
                    "SELECT id, " + "birthdate, " + "first_name, " +
                    "last_name, email, phone, username " + " FROM " + "user " +
                    "WHERE first_name " + "like '" + enteredSearchTerm + "%';");
            resultSet         = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String userID    = resultSet.getString("id");
                String firstName = resultSet.getString("first_name");
                String lastName  = resultSet.getString("last_name");
                User   user      = new User();
                user.setId(Long.valueOf(resultSet.getString("id")));
                user.setFirstName(resultSet.getString("birthdate"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setUsername(resultSet.getString("username"));
                search.addFoundUser(user);
                search.setIsUserFound(true);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        catch (Exception exception)
        {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (statement != null)
                {
                    statement.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }
}
