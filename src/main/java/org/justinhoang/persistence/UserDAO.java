package org.justinhoang.persistence;

import org.justinhoang.model.User;

import java.util.List;

public interface UserDAO {
    void create(User obj);
    User read(Integer id);
    List<User> readAll();
    void delete(Integer id);
}
