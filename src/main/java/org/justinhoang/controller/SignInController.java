package org.justinhoang.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.util.PropLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Sign in controller.
 */
@WebServlet(urlPatterns = {"/login"})

public class SignInController extends HttpServlet implements PropLoader
{
    /**
     * The Properties.
     */
    Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The constant CLIENT_ID.
     */
    public static String CLIENT_ID;
    /**
     * The constant LOGIN_URL.
     */
    public static String LOGIN_URL;
    /**
     * The constant REDIRECT_URL.
     */
    public static String REDIRECT_URL;

    @Override
    public void init() throws ServletException
    {
        super.init();
        load();
    }

    /**
     * Read in the cognito props file and get the client id and required urls
     * for authenticating a user.
     */
    // TODO This code appears in a couple classes, consider using a startup
    //  servlet similar to adv java project
    // 4 to do this work a single time and put the properties in the
    // application scope
    private void load()
    {
        try
        {
            properties   = load("cognito.properties");
            CLIENT_ID    = properties.getProperty("client.id");
            LOGIN_URL    = properties.getProperty("loginURL");
            REDIRECT_URL = properties.getProperty("redirectURL");
        }
        catch (Exception e)
        {
            logger.error("Error loading properties" + e.getMessage(), e);
        }
    }

    /**
     * Route to the aws-hosted cognito login page.
     *
     * @param req
     *         servlet request
     * @param resp
     *         servlet response
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
                                                                           IOException
    {
        // TODO if properties weren't loaded properly, route to an error page
        String url = LOGIN_URL + "?response_type=code&client_id=" + CLIENT_ID +
                     "&redirect_uri=" + REDIRECT_URL;
        resp.sendRedirect(url);
    }
}

