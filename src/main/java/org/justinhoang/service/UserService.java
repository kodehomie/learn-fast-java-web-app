package org.justinhoang.service;

import org.justinhoang.entity.User;

import java.util.List;

public interface UserService
{

    void createUser(User user);

    User readUser(Long id);

    List<User> readUsers();

    void deleteUser(Long id);

}
