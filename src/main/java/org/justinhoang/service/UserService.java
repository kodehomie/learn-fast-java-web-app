package org.justinhoang.service;

import java.util.List;

import org.justinhoang.entity.User;

import javax.transaction.Transactional;

public interface UserService {


    @Transactional
    User createUser(User user);

    @Transactional
    User readUser(int id);

    @Transactional
    List<User> readAllUsers();

    @Transactional
    void updateUser(User user);

    @Transactional
    void deleteUser(Integer id);



}
