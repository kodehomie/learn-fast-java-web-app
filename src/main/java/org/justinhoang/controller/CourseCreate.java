//package org.justinhoang.controller;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.justinhoang.entity.Course;
//import org.justinhoang.persistence.GenericDao;
//import org.justinhoang.util.DaoFactory;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "CourseCreate", urlPatterns = {"/createCourse"})
//
//public class CourseCreate extends HttpServlet
//{
//
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
//                                                                            ServletException,
//                                                                            IOException
//    {
//
//        Course course = new Course();
//        course.setTitle(req.getParameter("title"));
//
//        GenericDao<?> sectionDao = DaoFactory.createDao(CourseFormat.class);
//
//        CourseSection courseSection = (CourseSection) sectionDao.readById(
//                Integer.parseInt(req.getParameter("section")));
////        course.setCourseSection(courseSection);
//
//
//        GenericDao dao = DaoFactory.createDao(Course.class);
//        int        id  = dao.create(course);
//
//        req.setAttribute("course", dao.readById(id));
//        logger.debug("Getting the course...");
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/readCourses");
//        dispatcher.forward(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
//                                                                           ServletException,
//                                                                           IOException
//    {
//
//        req.setAttribute("types", getAllTypes());
//
//        RequestDispatcher dispatcher =
//                req.getRequestDispatcher("/create-course" + ".jsp");
//        dispatcher.forward(req, resp);
//    }
//
//    private List<CourseFormat> getAllTypes()
//    {
//        GenericDao dao = DaoFactory.createDao(CourseFormat.class);
//        logger.debug("Types" + dao.readAll());
//        return dao.readAll();
//    }
//}
