package org.justinhoang.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.Course;
import org.justinhoang.exception.ResourceNotFoundException;
import org.justinhoang.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Course controller.
 */
@Controller
@RequestMapping("/course")
public class CourseController
{
    @Autowired
    private       CourseService courseService;
    private final Logger      logger = LogManager.getLogger(this.getClass());

    /**
     * Course create string.
     *
     * @param course
     *         the course
     *
     * @return the string
     */
    @PostMapping("/courseCreate")
    public String courseCreate(@ModelAttribute("course") Course course)
    {
        courseService.createCourse(course);
        return "redirect:/course/courses-read";
    }

    /**
     * Course create form string.
     *
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @GetMapping("/courseCreateForm")
    public String courseCreateForm(Model entity)
    {
        Course course = new Course();
        entity.addAttribute("course", course);
        return "course-form";
    }

    /**
     * Courses read string.
     *
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @GetMapping("/coursesRead")
    public String coursesRead(Model entity)
    {
        List<Course> courses = courseService.readCourses();
        entity.addAttribute("courses", courses);
        return "courses-read";
    }

    /**
     * Course update form string.
     *
     * @param id
     *         the id
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @GetMapping("/courseUpdateForm")
    public String courseUpdateForm(@RequestParam("id") Long id, Model entity) throws
                                                                            ResourceNotFoundException

    {
        Course course = courseService.readCourse(id);
        entity.addAttribute("course", course);
        return "course-form";
    }

    /**
     * Course delete string.
     *
     * @param id
     *         the id
     *
     * @return the string
     */
    @GetMapping("/courseDelete")
    public String courseDelete(@RequestParam("id") Long id) throws
                                                          ResourceNotFoundException
    {
        courseService.deleteCourse(id);
        return "redirect:/course/courses-read";
    }
}
