package org.justinhoang.conf;

import org.justinhoang.persistence.UserAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * [Spring MVC Root Web Application Context]
 * (containing middle-tier services, data sources, etc.)
 * The root WebApplicationContext typically contains infrastructure beans,
 * such as data repositories and business services that need to
 * be shared across multiple Servlet instances.
 * Those beans are effectively inherited and can be overridden
 * (that is, re-declared) in the Servlet-specific child WebApplicationContext,
 * which typically contains beans local to the given Servlet.
 *
 * @author jkhoang
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.justinhoang")
public class RootWebAppConf implements WebMvcConfigurer {

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
}
