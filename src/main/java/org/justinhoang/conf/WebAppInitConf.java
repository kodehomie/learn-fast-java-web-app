//package org.justinhoang.conf;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.justinhoang.util.PropertiesLoader;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.servlet.MultipartConfigElement;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletRegistration;
//import java.io.IOException;
//import java.util.Properties;
//
///**
// * [Spring MVC Dispatcher Servlet]
// * The front controller pattern's central servlet, the dispatcher servlet,
// * provides a shared algorithm for request processing,
// * while actual work is performed by configurable delegate components.
// * DispatcherServlet expects a WebApplicationContext
// * (an extension of a plain ApplicationContext) for its own configuration.
// *
// * @author jkhoang
// */
//public class WebAppInitConf
//        implements WebApplicationInitializer, PropertiesLoader
//{
//    Properties properties;
//    private final Logger logger = LogManager.getLogger(this.getClass());
//    public static String CLIENT_ID;
//    public static String LOGIN_URL;
//    public static String REDIRECT_URL;
//
//    @Override public void onStartup(ServletContext servletContext)
//    {
//
//        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//        appContext.setConfigLocation("/WEB-INF/mvc-dispatcher-config.xml");
//
//        ServletRegistration.Dynamic registration = container.addServlet(
//                "dispatcher", new DispatcherServlet(appContext));
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//
//    }
//
//    private void loadProperties()
//    {
//        try
//        {
//            properties   = loadProperties("/cognito.properties");
//            CLIENT_ID    = properties.getProperty("client.id");
//            LOGIN_URL    = properties.getProperty("loginURL");
//            REDIRECT_URL = properties.getProperty("redirectURL");
//        }
//        catch (IOException ioException)
//        {
//            logger.error("Cannot load properties..." + ioException.getMessage(),
//                         ioException);
//        }
//        catch (Exception e)
//        {
//            logger.error("Error loading properties" + e.getMessage(), e);
//        }
//    }
//
//    protected void customizeRegistration(ServletRegistration.Dynamic registration)
//    {
//
//        // Optionally also set maxFileSize, maxRequestSize, fileSizeThreshold
//        registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
//    }
//
//}
////        // Load Spring web application configuration
////        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
////        context.register(AppConfig.class);
////
////        // Create and register the DispatcherServlet
////        DispatcherServlet servlet = new DispatcherServlet(context);
////        ServletRegistration.Dynamic registration = servletContext.addServlet("learnfast", servlet);
////        registration.setLoadOnStartup(1);
////        registration.addMapping("/");
////    }
////}