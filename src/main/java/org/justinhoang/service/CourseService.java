package org.justinhoang.service;

import org.justinhoang.entity.Course;
import org.justinhoang.exception.ResourceNotFoundException;

import java.util.List;

/**
 * The interface Course service.
 */
public interface CourseService
{
    /**
     * Create course.
     *
     * @param course
     *         the course
     */
    void createCourse(Course course);

    /**
     * Read course course.
     *
     * @param id
     *         the id
     *
     * @return the course
     *
     * @throws ResourceNotFoundException
     *         the resource not found exception
     */
    Course readCourse(Long id) throws ResourceNotFoundException;

    /**
     * Read courses list.
     *
     * @return the list
     */
    List<Course> readCourses();

    /**
     * Update course.
     *
     * @param course
     *         the course
     */
    void updateCourse(Course course);

    /**
     * Delete course.
     *
     * @param id
     *         the id
     *
     * @throws ResourceNotFoundException
     *         the resource not found exception
     */
    void deleteCourse(Long id) throws ResourceNotFoundException;
}