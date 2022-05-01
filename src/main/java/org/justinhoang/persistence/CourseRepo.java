package org.justinhoang.persistence;

import org.justinhoang.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Course repo.
 */
@Repository("courseRepo")
public interface CourseRepo extends JpaRepository<Course, Long>
{
}
