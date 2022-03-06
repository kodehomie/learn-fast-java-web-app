//package org.justinhoang.conf;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
///**
// * [Spring MVC Servlet Web Application Context]
// * (containing controllers, view resolvers, and other web related beans)
// *
// * @author jkhoang
// */
//@Configuration
//@EnableWebMvc
//@ComponentScan("org.justinhoang")
//public class ServWebAppConf implements WebMvcConfigurer
//{
//
//    //    private static final int BROWSER_CACHE_CONTROL = 604800;
//    private static final int BROWSER_CACHE_CONTROL = 10;
//
//
//    // Controllers
//    @Override public void addViewControllers(ViewControllerRegistry registry)
//    {
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/signup").setViewName("signup");
//        registry.addViewController("/signin").setViewName("signin");
//        registry.addViewController("/welcome").setViewName("welcome");
//    }
//
//    @Override public void addResourceHandlers(ResourceHandlerRegistry registry)
//    {
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("/", "classpath:webapp/resources/")
//                .addResourceLocations("/resources/")
//                .setCachePeriod(BROWSER_CACHE_CONTROL);
//        registry.addResourceHandler("/css/**", "/css/{filename:\\w+\\}.css")
//                .addResourceLocations("/", "classpath:webapp/resources/css/")
//                .addResourceLocations("/css/")
//                .setCachePeriod(BROWSER_CACHE_CONTROL);
//        registry.addResourceHandler("/img/**", "/img/{filename:\\w+\\}.*")
//                .addResourceLocations("/", "classpath:webapp/resources/img/")
//                .addResourceLocations("/img/")
//                .setCachePeriod(BROWSER_CACHE_CONTROL);
//        registry.addResourceHandler("/js/**", "/js/{filename:\\w+\\}.js")
//                .addResourceLocations("/", "classpath:webapp/resources/js/")
//                .addResourceLocations("/js/")
//                .setCachePeriod(BROWSER_CACHE_CONTROL);
//        registry.addResourceHandler("/jsp/**", "/jsp/{filename:\\w+\\}.jsp")
//                .addResourceLocations("/", "classpath:webapp/resources/jsp/")
//                .addResourceLocations("/jsp/")
//                .setCachePeriod(BROWSER_CACHE_CONTROL);
//    }
//
//    // View Resolvers
//    @Bean InternalResourceViewResolver viewResolver()
//    {
//        InternalResourceViewResolver vr = new InternalResourceViewResolver();
//        vr.setPrefix("/");
//        vr.setSuffix(".jsp");
//        return vr;
//    }
//
//    // Handler Mappings
//
//}
