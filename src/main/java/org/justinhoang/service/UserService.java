package org.justinhoang.service;

import org.justinhoang.entity.User;
import org.justinhoang.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {

    void createUser(User user);
    User readUser(Long id) throws ResourceNotFoundException;
    List<User> readUsers();
    void updateUser(User user);
    void deleteUser(Long id) throws ResourceNotFoundException;

}