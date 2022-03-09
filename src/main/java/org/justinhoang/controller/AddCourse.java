package org.justinhoang.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.Course;
import org.justinhoang.entity.CourseType;
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

@WebServlet(name = "AddCourse", urlPatterns = {"/addCourse"})

public class AddCourse extends HttpServlet
{

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
                                                                            ServletException,
                                                                            IOException
    {

        Course course = new Course();
        course.setTitle(req.getParameter("title"));

        GenericDao typeDao = DaoFactory.createDao(CourseType.class);

        CourseType type = (CourseType) typeDao.getById(
                Integer.parseInt(req.getParameter("type")));
        course.setCourseType(type);

        GenericDao userDao = DaoFactory.createDao(User.class);
        User user = (User) userDao.findByPropertyEqual("userName",
                                                       req.getRemoteUser())
                                  .get(0);
        course.setUser(user);

        GenericDao dao = DaoFactory.createDao(Course.class);
        int        id  = dao.insert(course);

        req.setAttribute("course", dao.getById(id));
        logger.debug("Getting the course...");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewCourses");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
                                                                           ServletException,
                                                                           IOException
    {

        req.setAttribute("types", getAllTypes());

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/addCourse" + ".jsp");
        dispatcher.forward(req, resp);
    }

    private List<CourseType> getAllTypes()
    {
        GenericDao dao = DaoFactory.createDao(CourseType.class);
        logger.debug("Types" + dao.readAll());
        return dao.readAll();
    }
}
