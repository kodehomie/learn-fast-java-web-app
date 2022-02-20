package org.justinhoang.persistence;

import org.justinhoang.model.Role;

import java.util.List;

public interface RoleDAO {
    void create(Role obj);

    Role read(Integer id);

    List<Role> readAll();

    void delete(Integer id);
}
