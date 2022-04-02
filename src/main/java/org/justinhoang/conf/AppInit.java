package org.justinhoang.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * The type App init.
 */
public class AppInit
        extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]{AppContext.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]{WebMvcConf.class};
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[]{"/"};
    }
}
