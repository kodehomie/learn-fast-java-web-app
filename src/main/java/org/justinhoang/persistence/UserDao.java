package org.justinhoang.persistence;

import org.justinhoang.entity.User;

import java.util.List;

public interface UserDao
{
    User readUser(Long id);

    List<User> readUsers();

    void createUser(User user);

    void deleteUser(Long id);
}
