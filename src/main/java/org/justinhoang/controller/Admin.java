package org.justinhoang.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.Course;
import org.justinhoang.entity.User;
import org.justinhoang.persistence.GenericDao;
import org.justinhoang.util.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Admin.
 */
@WebServlet(urlPatterns = {"/admin"})

public class Admin extends HttpServlet
{

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
                                                                           ServletException,
                                                                           IOException
    {

        GenericDao<User>   user       = DaoFactory.createDao(User.class);
        GenericDao<Course> course     = DaoFactory.createDao(Course.class);
        List<User>         allUsers   = user.readAll();
        List<Course>       allCourses = course.readAll();
        req.setAttribute("users", allUsers);
        logger.debug("Users: " + allUsers);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(req, resp);
    }

}
