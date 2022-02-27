package org.justinhoang.controller;

import com.mysql.cj.Messages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.User;
import org.justinhoang.entity.UserRole;
import org.justinhoang.persistence.GenericDao;
import org.justinhoang.util.DaoFactory;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Sign up.
 */
@WebServlet
        (urlPatterns = {"/signup"})
public class SignUp extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    /**
     * Instantiates a new Sign up.
     */
// constructor
    public SignUp() {
        loadProperties();
    }

    // load properties
    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/url.properties"));
        } catch (IOException ioe) {
            logger.error("DB.loadProperties()...fail load properties file..." + ioe);
        } catch (Exception e) {
            logger.error("DB.loadProperties()..." + e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        GenericDao<User> genericDao = DaoFactory.createDao(User.class);
        User newUser = new User(req.getParameter("first_name"), req.getParameter("last_name"), req.getParameter("email"), req.getParameter("username"), req.getParameter("password"));
        String userRoleName = "user";
        String userName = req.getParameter("username");
        UserRole userRoles = new UserRole(userRoleName, userName, newUser);
        newUser.addUserRoles(userRoles);
        int id = genericDao.create(newUser);
        User createdUser = (User) genericDao.getById(id);
        resp.sendRedirect(properties.getProperty("local") + "/signinAction");

    }


}
