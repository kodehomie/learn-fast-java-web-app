package org.justinhoang.persistence;

import org.justinhoang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User repo.
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long>
{

}
