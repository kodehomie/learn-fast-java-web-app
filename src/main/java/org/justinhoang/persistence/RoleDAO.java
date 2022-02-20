package org.justinhoang.persistence;

import org.justinhoang.model.Role;

import java.util.List;

/** The interface Role dao. */
public interface RoleDAO {
  /**
   * Create.
   *
   * @param obj the obj
   */
  void create(Role obj);

  /**
   * Read role.
   *
   * @param id the id
   * @return the role
   */
  Role read(Integer id);

  /**
   * Read all list.
   *
   * @return the list
   */
  List<Role> readAll();

  /**
   * Delete.
   *
   * @param id the id
   */
  void delete(Integer id);
}
