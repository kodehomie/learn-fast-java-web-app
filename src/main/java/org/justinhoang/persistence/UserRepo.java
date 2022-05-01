package org.justinhoang.persistence;

import org.justinhoang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User repo.
 * Hibernate used for all data access.
 */
@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Long>
{
}
