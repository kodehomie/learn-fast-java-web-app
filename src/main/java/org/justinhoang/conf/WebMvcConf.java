package org.justinhoang.conf;

import org.justinhoang.persistence.UserAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.time.Duration;

@Configuration
@EnableWebMvc
@ComponentScan("org.justinhoang")
public class WebMvcConf implements WebMvcConfigurer {

    @Bean
    InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/");
        vr.setSuffix(".jsp");
        return vr;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/signup.jsp").setViewName("signup");
        registry.addViewController("/signin.jsp").setViewName("signin");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/", "classpath:webapp/resources/")
                .addResourceLocations("/css/")
                .addResourceLocations("/img/")
                .addResourceLocations("/js/");

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
    public UserAuth getUserAuth() {
        return new UserAuth(getDataSource());
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LocaleChangeInterceptor());
//        registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
//        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
//    }

}
