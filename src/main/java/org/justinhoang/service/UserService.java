package org.justinhoang.service;

import org.justinhoang.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();
}