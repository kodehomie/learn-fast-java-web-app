package org.justinhoang.service;

import org.justinhoang.entity.Course;
import org.justinhoang.exception.ResourceNotFoundException;
import org.justinhoang.persistence.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Course service imp.
 */
@Service
public class CourseServiceImp implements CourseService
{
    @Autowired
    private CourseRepo courseRepo;

    @Override
    @Transactional
    public void createCourse(final Course course)
    {
        courseRepo.save(course);
    }

    @Override
    @Transactional
    public Course readCourse(final Long id) throws ResourceNotFoundException
    {
        return courseRepo.findById(id)
                       .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public List<Course> readCourses()
    {
        return courseRepo.findAll();
    }

    @Override
    @Transactional
    public void updateCourse(final Course course)
    {
        courseRepo.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(final Long id)
    {
        courseRepo.deleteById(id);
    }
}
