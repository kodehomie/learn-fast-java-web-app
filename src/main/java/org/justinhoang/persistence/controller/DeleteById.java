package org.justinhoang.persistence.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.Course;
import org.justinhoang.persistence.GenericDao;
import org.justinhoang.util.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/deleteById"}
)

public class DeleteById extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Course> genDao = DaoFactory.createDao(Course.class);
        genDao.delete(genDao.readById(Integer.parseInt(req.getParameter(
                "DeleteById"))));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin");
        dispatcher.forward(req, resp);
    }
}

