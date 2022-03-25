package org.justinhoang.persistence;

import org.justinhoang.entity.User;

import java.util.List;

/**
 * The interface User dao.
 */
public interface UserDao
{
    /**
     * Create user.
     *
     * @param user
     *         the user
     */
    void createUser(User user);

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
     * Update user.
     *
     * @param user
     *         the user
     */
    void updateUser(User user);

    /**
     * Delete user.
     *
     * @param id
     *         the id
     */
    void deleteUser(Long id);
}
