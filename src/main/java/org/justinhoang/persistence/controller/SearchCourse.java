package org.justinhoang.persistence.controller;

import org.justinhoang.entity.Course;
import org.justinhoang.persistence.GenericDao;
import org.justinhoang.util.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/searchCourse"})

public class SearchCourse extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
                                                                           ServletException,
                                                                           IOException
    {
        GenericDao<Course> genDao = DaoFactory.createDao(Course.class);
//        if (req.getParameter("submit").equals("search"))
//        {
//            req.setAttribute("courses", genDao.readById(
//                    Integer.parseInt(req.getParameter("searchTerm"))));
//        }

//        else
//        {
//            req.setAttribute("courses", genDao.readAll());
//        }
                if (req.getParameter("submit").equals("search"))
                {
                    req.setAttribute("courses", genDao.readById(
                            Integer.parseInt(req.getParameter("searchTerm")
                            )));
                }
                else if (req.getParameter("searchType").equals("id"))
                {
                    req.setAttribute("courses", genDao.readById(
                            Integer.parseInt(req.getParameter("searchTerm")
                            )));
                }
                else if (req.getParameter("searchType").equals("id"))
                {
                    req.setAttribute("courses",
                                     genDao.findByPropertyLike
                                     ("searchTerm", "id"));
                }
                else if (req.getParameter("searchType").equals("title"))
                {
                    req.setAttribute("courses",
                                     genDao.findByPropertyLike
                                     ("searchTerm", "title"));
                }
                else if (req.getParameter("searchType").equals("section"))
                {
                    req.setAttribute("courses", genDao.findByPropertyLike
                    ("searchTerm",
                                                                           "section"));
                }
                else if (req.getParameter("searchType").equals
                ("sectionStatus"))
                {
                    req.setAttribute("courses", genDao.findByPropertyLike
                    ("searchTerm",
                                                                           "sectionStatus"));
                }
                else if (req.getParameter("searchType").equals("meets"))
                {
                    req.setAttribute("courses",
                                     genDao.findByPropertyLike
                                     ("searchTerm", "meets"));
                }
                else if (req.getParameter("searchType").equals("dates"))
                {
                    req.setAttribute("courses",
                                     genDao.findByPropertyLike
                                     ("searchTerm", "dates"));
                }
                else
                {
                    req.setAttribute("courses", genDao.readAll());
                }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/courses.jsp");
        dispatcher.forward(req, resp);
    }
}
