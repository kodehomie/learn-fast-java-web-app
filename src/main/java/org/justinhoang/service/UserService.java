package org.justinhoang.service;

import org.justinhoang.entity.User;
import org.justinhoang.exception.ResourceNotFoundException;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService
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
     *
     * @throws ResourceNotFoundException
     *         the resource not found exception
     */
    User readUser(Long id) throws ResourceNotFoundException;

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
     *
     * @throws ResourceNotFoundException
     *         the resource not found exception
     */
    void deleteUser(Long id) throws ResourceNotFoundException;
}