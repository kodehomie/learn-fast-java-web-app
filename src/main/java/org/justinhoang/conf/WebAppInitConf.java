package org.justinhoang.conf;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * [Spring MVC Dispatcher Servlet]
 * The front controller pattern's central servlet, the dispatcher servlet,
 * provides a shared algorithm for request processing,
 * while actual work is performed by configurable delegate components.
 * DispatcherServlet expects a WebApplicationContext
 * (an extension of a plain ApplicationContext) for its own configuration.
 *
 * @author jkhoang
 */
public class WebAppInitConf implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
    }
}