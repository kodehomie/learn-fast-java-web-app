package org.justinhoang.conf;

import org.justinhoang.persistence.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.justinhoang.persistence.UserDao;

@Configuration
@EnableWebMvc
@ComponentScan("org.justinhoang")
public class WebMvcConf implements WebMvcConfigurer {

//    @Bean
//    InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver vr = new InternalResourceViewResolver();
//        vr.setPrefix("/");
//        vr.setSuffix(".jsp");
//        return vr;
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/signup.jsp").setViewName("signup");
        registry.addViewController("/signin.jsp").setViewName("signin");
    }

    @Bean
    DriverManagerDataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/learnfasttest");
        ds.setUsername("root");
        ds.setPassword("root");

        return ds;

    }

    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl(getDataSource());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //specifying static resource location
        registry.addResourceHandler("webapp/resources/**")
                .addResourceLocations("/css/")
                .addResourceLocations("/img/")
                .addResourceLocations("/js/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
        registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
    }

}
