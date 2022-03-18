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
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "CourseSearch",
//            urlPatterns = {"/courseSearch"})
//
//public class CourseSearch extends HttpServlet
//{
//
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
//                                                                           ServletException,
//                                                                           IOException
//    {
//
//        GenericDao<Course> courseDao =
//                (GenericDao<Course>) DaoFactory.createDao(Course.class);
//        List<Course> courses = courseDao.readAll();
////        req.setAttribute("courses", courses);
//        logger.debug("Courses: " + courses);
//
//        if (req.getParameter("submit").equals("search"))
//        {
//            req.setAttribute("courses", courseDao.readById(Math.toIntExact(
//                    Long.parseLong(req.getParameter("searchTerm")))));
//        }
//
//        else
//        {
//            req.setAttribute("courses", courses);
//        }
//        //                if (req.getParameter("submit").equals("search"))
//        //                {
//        //                    req.setAttribute("courses", courseDao.readById(
//        //                            Integer.parseInt(req.getParameter
//        //                            ("searchTerm")
//        //                            )));
//        //                }
//        //                else if (req.getParameter("searchType").equals("id"))
//        //                {
//        //                    req.setAttribute("courses", courseDao.readById(
//        //                            Integer.parseInt(req.getParameter
//        //                            ("searchTerm")
//        //                            )));
//        //                }
//        //                else if (req.getParameter("searchType").equals("id"))
//        //                {
//        //                    req.setAttribute("courses",
//        //                                     courseDao.findByPropertyLike
//        //                                     ("searchTerm", "id"));
//        //                }
//        //                else if (req.getParameter("searchType").equals
//        //                ("title"))
//        //                {
//        //                    req.setAttribute("courses",
//        //                                     courseDao.findByPropertyLike
//        //                                     ("searchTerm", "title"));
//        //                }
//        //                else if (req.getParameter("searchType").equals
//        //                ("section"))
//        //                {
//        //                    req.setAttribute("courses", courseDao
//        //                    .findByPropertyLike
//        //                    ("searchTerm",
//        //                                                                           "section"));
//        //                }
//        //                else if (req.getParameter("searchType").equals
//        //                ("sectionStatus"))
//        //                {
//        //                    req.setAttribute("courses", courseDao
//        //                    .findByPropertyLike
//        //                    ("searchTerm",
//        //                                                                           "sectionStatus"));
//        //                }
//        //                else if (req.getParameter("searchType").equals
//        //                ("meets"))
//        //                {
//        //                    req.setAttribute("courses",
//        //                                     courseDao.findByPropertyLike
//        //                                     ("searchTerm", "meets"));
//        //                }
//        //                else if (req.getParameter("searchType").equals
//        //                ("dates"))
//        //                {
//        //                    req.setAttribute("courses",
//        //                                     courseDao.findByPropertyLike
//        //                                     ("searchTerm", "dates"));
//        //                }
//        //                else
//        //                {
//        //                    req.setAttribute("courses", courseDao.readAll());
//        //                }
//
//        RequestDispatcher dispatcher =
//                req.getRequestDispatcher("/courses-read.jsp");
//        dispatcher.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
//                                                                            ServletException,
//                                                                            IOException
//    {
//        doGet(req, resp);
//    }
//}
