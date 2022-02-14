package org.justinhoang.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.Role;
import org.justinhoang.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpUser", urlPatterns = { "/sign-up" } )
public class SignUpUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user;
        Role role = null;
        user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        logger.debug("Add User: " + user);
        role.setUser(user);
        role.setRole("user");
        user.addRole(role);

        RequestDispatcher dispatcher = req.getRequestDispatcher(
                "/sign-up-confirmation" +
                ".jsp");
        dispatcher.forward(req, res);
    }
}
