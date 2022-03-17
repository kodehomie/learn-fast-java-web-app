package org.justinhoang.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userSearchDisplay",
            urlPatterns = {"/user-search"})
public class UserSearchDisplay extends HttpServlet
{

    public void init() throws ServletException
    {
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws
                                                                                ServletException,
                                                                                IOException
    {
        String            url;
        RequestDispatcher dispatcher;
        url        = "/user-search.jsp";
        dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
                                                                                 ServletException,
                                                                                 IOException
    {
    }

    public void destroy()
    {
    }
}

