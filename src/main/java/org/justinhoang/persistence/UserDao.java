package org.justinhoang.persistence;

import org.justinhoang.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> list();
}