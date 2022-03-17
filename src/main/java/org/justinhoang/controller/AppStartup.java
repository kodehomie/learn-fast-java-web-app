package org.justinhoang.controller;

import org.justinhoang.util.PropertiesLoader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

/**
 * The type App startup.
 */
@WebServlet(name = "appStartup",
            urlPatterns = {"/app-startup"},
            loadOnStartup = 1)
public class AppStartup extends HttpServlet implements PropertiesLoader
{

    private String CLIENT_ID;
    private String CLIENT_SECRET;
    private String OAUTH_URL;
    private String LOGIN_URL;
    private String REDIRECT_URL;
    private String REGION;
    private String POOL_ID;

    private Properties properties;

    /**
     * Instantiates a new App startup.
     */
    public AppStartup()
    {
        assert false;
        String propertiesFilePath = "cognito.properties";
        properties    = new Properties(load(propertiesFilePath));
        CLIENT_ID     = properties.getProperty("client.id");
        CLIENT_SECRET = properties.getProperty("client.secret");
        OAUTH_URL     = properties.getProperty("oauthURL");
        LOGIN_URL     = properties.getProperty("loginURL");
        REDIRECT_URL  = properties.getProperty("redirectURL");
        REGION        = properties.getProperty("region");
        POOL_ID       = properties.getProperty("poolId");
    }

    public void init() throws ServletException
    {
        super.init();
        ServletContext servletContext;
        servletContext = getServletContext();
        String propertiesFilePath = "cognito.properties";
        servletContext.setAttribute("cognitoProperties", properties);
        try
        {
            new AppStartup();
            properties    = new Properties(load(propertiesFilePath));
            CLIENT_ID     = properties.getProperty("client.id");
            CLIENT_SECRET = properties.getProperty("client.secret");
            OAUTH_URL     = properties.getProperty("oauthURL");
            LOGIN_URL     = properties.getProperty("loginURL");
            REDIRECT_URL  = properties.getProperty("redirectURL");
            REGION        = properties.getProperty("region");
            POOL_ID       = properties.getProperty("poolId");
            servletContext.setAttribute("cognitoProperties", properties);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws
                                                                                ServletException,
                                                                                IOException
    {
        HttpSession       httpsession;
        String            driver;
        String            username;
        String            password;
        String            url;
        RequestDispatcher dispatcher;
        url        = "/app-startup.jsp";
        dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}

