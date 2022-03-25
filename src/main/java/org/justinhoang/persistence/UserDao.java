package org.justinhoang.persistence;

import org.justinhoang.entity.User;

import java.util.List;

/**
 * The interface User dao.
 */
public interface UserDao
{
    /**
     * Read user user.
     *
     * @param id
     *         the id
     *
     * @return the user
     */
    User readUser(Long id);

    /**
     * Read users list.
     *
     * @return the list
     */
    List<User> readUsers();

    /**
     * Create user.
     *
     * @param user
     *         the user
     */
    void createUser(User user);

    /**
     * Delete user.
     *
     * @param id
     *         the id
     */
    void deleteUser(Long id);
}
