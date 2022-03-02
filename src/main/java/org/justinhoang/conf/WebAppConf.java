package org.justinhoang.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * [Spring MVC Web Application Context Hierarchy Configuration]
 * Front Controller
 *
 * @author jkhoang
 */
public class WebAppConf extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootWebAppConf.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ServWebAppConf.class };
        //return null;
    }

    @Override
    protected String[] getServletMappings() {
        //return new String[]{"/*"};
        return new String[] { "/" };
    }
}
