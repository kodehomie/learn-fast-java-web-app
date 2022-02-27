//package org.justinhoang.controller;
//
//import org.justinhoang.util.PropertiesLoader;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.Properties;
//
//@WebServlet(
//        name = "appStartUp",
//        urlPatterns = {"/app-startup"},
//        loadOnStartup = 1
//)
//public class AppStartUp extends HttpServlet implements PropertiesLoader {
//    /**
//     * This declaration, "properties",
//     * is a Properties instance variable
//     * that represents properties.
//     */
//    private Properties properties;
//
//    public void init() throws ServletException {
//        ServletContext servletContext;
//        servletContext = getServletContext();
//        String propertiesFilePath = "/app.properties";
//        properties = new Properties(loadProperties(propertiesFilePath));
//        servletContext.setAttribute("appProperties", properties);
//    }
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        HttpSession httpsession;
//        String driver;
//        String username;
//        String password;
//        String url;
//        RequestDispatcher dispatcher;
//        httpsession = req.getSession();
//        driver = properties.getProperty("driver");
//        username = properties.getProperty("username");
//        password = properties.getProperty("password");
//        req.setAttribute("appProperties", properties);
//        req.setAttribute("driver", driver);
//        req.setAttribute("username", username);
//        req.setAttribute("password", password);
//        url = "/app-startup.jsp";
//        dispatcher = getServletContext().getRequestDispatcher(url);
//        dispatcher.forward(req, resp);
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//    }
//
//    public void destroy() {
//    }
//}
//
