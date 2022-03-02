package org.justinhoang.conf;

import org.justinhoang.persistence.UserAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


// RootWebApplicationContext
// Containing middle-tier services, datasources, etc.
//@Configuration
//@EnableWebMvc
//@ComponentScan("org.justinhoang")
//public class WebMvcConf implements WebMvcConfigurer {

//    private static final int BROWSER_CACHE_CONTROL = 604800;
//
//    @Bean
//    InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver vr = new InternalResourceViewResolver();
//        vr.setPrefix("/");
//        vr.setSuffix(".jsp");
//        return vr;
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/signup").setViewName("signup");
//        registry.addViewController("/signin").setViewName("signin");
//        registry.addViewController("/welcome").setViewName("welcome");
//    }
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
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
//        registry.addResourceHandler("/jsp/**", "**/jsp/{filename:\\w+\\}.jsp")
//                .addResourceLocations("/", "classpath:webapp/resources/jsp/")
//                .addResourceLocations("/jsp/")
//                .setCachePeriod(BROWSER_CACHE_CONTROL);
//    }

//    @Bean
//    DriverManagerDataSource getDataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/learnfasttest");
//        ds.setUsername("root");
//        ds.setPassword("root");
//
//        return ds;
//
//    }
//
//    @Bean
//    public UserAuth getUserAuth() {
//        return new UserAuth(getDataSource());
//    }

//}
