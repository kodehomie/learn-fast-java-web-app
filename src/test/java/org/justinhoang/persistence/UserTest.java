package org.justinhoang.persistence;

import org.junit.Before;
import org.junit.Test;
import org.justinhoang.entity.User;
import org.justinhoang.entity.UserRole;
import util.DbUtil;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;


/**
 * The type User test.
 */
public class UserTest {


    GenericDao dao;

    /**
     * The Db util.
     */
    DbUtil dbUtil;

    /**
     * The Users.
     */
    List<User> users;


    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        dao = new GenericDao(User.class);
        dbUtil = new DbUtil();
        dbUtil.runSQL("testdb.sql");
        users = dao.getAll();
    }


    /**
     * Test get all users.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAllUsers() throws Exception {
        assertTrue(users.size() > 0);
        assertFalse(users.get(0).getFirstName().equals(""));
    }

    /**
     * Test update user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUpdateUser() throws Exception {
        User user = users.get(0);
        int id = user.getId();
        String updateValue = LocalDate.now().toString();
        String emailBeforeUpdate = user.getEmail();
        // it would be a good idea to test each value like this

        user.setEmail(user.getEmail() + updateValue);

        dao.update(user);

        User updatedUser = (User) dao.getById(id);

        assertEquals(user, updatedUser);

    }

    /**
     * Test delete user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDeleteUser() throws Exception {
        int sizeBeforeDelete = users.size();
        User userToDelete = users.get(0);
        int id = userToDelete.getId();
        dao.delete(userToDelete);
        int sizeAfterDelete = dao.getAll().size();

        User deletedUser = (User) dao.getById(id);

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertNull(deletedUser);

    }

    /**
     * Test add user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddUser() throws Exception {

        int createdUserId = 0;

        User user = new User();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setEmail("user-unit-test@gmail.com");
        user.setUsername("UnitTester");
        user.setPassword("password");

        UserRole role = new UserRole();
        role.setRole("admin");
        role.setUser(user);

        user.addUserRoles(role);

        createdUserId = dao.create(user);
        User retrievedUser = (User) dao.getById(createdUserId);

        assertTrue(createdUserId > 0);
        assertEquals(user, retrievedUser);
        assertEquals(1, retrievedUser.getUserRoles().size());
        assertTrue(retrievedUser.getUserRoles().contains(role));

    }

    /**
     * Test get all users with last name exact.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAllUsersWithLastNameExact() throws Exception {
        users = dao.getByPropertyEqual("lastName", "Test1");
        assertTrue(users.size() > 0);
        assertTrue(users.get(0).getFirstName().equals("Unit1"));
    }

}