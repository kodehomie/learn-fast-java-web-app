package org.justinhoang.service;

import org.justinhoang.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();
}