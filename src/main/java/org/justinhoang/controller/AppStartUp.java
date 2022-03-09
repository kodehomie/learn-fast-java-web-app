//package org.justinhoang.controller;
//
//import lombok.SneakyThrows;
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
//        urlPatterns = { "/app-startup" },
//        loadOnStartup = 1
//)
//public class AppStartUp extends HttpServlet implements PropertiesLoader
//{
//    /**
//     * This declaration, "properties",
//     * is a Properties instance variable
//     * that represents properties.
//     */
//    private Properties properties;
//
//    /**
//     * This instance method,
//     * "init", is called by the servlet engine to initialize servlet.
//     * @throws ServletException servlet exception.
//     */
//    public void init() throws ServletException {
//        super.init();
//
//        ServletContext servletContext;
//        servletContext = getServletContext();
//        String propertiesFilePath = "cognito.properties";
//        servletContext.setAttribute("cognitoProperties", properties);
//        try
//        {
//            load(propertiesFilePath);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        try
//        {
//            properties = new Properties(load(propertiesFilePath));
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//    }
//    /**
//     * This instance method,
//     * "doGet", processes the HTTP Get request.
//     * @param  request    Description of the Parameter
//     * @param  response    Description of the Parameter
//     * @throws ServletException    if there is a Servlet failure
//     * @throws IOException    if there is an IO failure
//     */
//    public void doGet(HttpServletRequest request, HttpServletResponse
//            response) throws ServletException, IOException {
//        HttpSession httpsession;
//
//    }
//    /**
//     * This instance method,
//     * "doPost", processes the HTTP Post request.
//     * @param  request    Description of the Parameter
//     * @param  response    Description of the Parameter
//     */
//    public void doPost(HttpServletRequest request, HttpServletResponse
//            response) {
//    }
//    /**
//     * This instance method,
//     * "destroy", is called by the servlet engine to release resource.
//     */
//    public void destroy() {
//    }
//}
//
