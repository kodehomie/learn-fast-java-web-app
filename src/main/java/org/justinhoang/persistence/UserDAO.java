package org.justinhoang.persistence;

import org.justinhoang.model.User;

import java.util.List;

/** The interface User dao. */
public interface UserDAO {

  /**
   * Create.
   *
   * @param obj the obj
   */
  void create(User obj);

  /**
   * Read user.
   *
   * @param id the id
   * @return the user
   */
  User read(Integer id);

  /**
   * Read all list.
   *
   * @return the list
   */
  List<User> readAll();

  /**
   * Delete.
   *
   * @param id the id
   */
  void delete(Integer id);
}
