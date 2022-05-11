package org.justinhoang.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * The type App context.
 */
@Configuration
@PropertySource("classpath:appcontext.properties")
@EnableTransactionManagement
@ComponentScan({"org.justinhoang"})
@EnableJpaRepositories(basePackages = "org.justinhoang.persistence")
public class AppContext
{
    @Autowired
    private Environment env;

    /**
     * Instantiates a new App context.
     */
    public AppContext()
    {
        super();
    }

    /**
     * Entity manager factory local container entity manager factory bean.
     *
     * @return the local container entity manager factory bean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
    {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("org.justinhoang.entity");

        final HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());

        return entityManagerFactoryBean;
    }

    /**
     * Data source data source.
     *
     * @return the data source
     */
    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    // Puts Hibernate properties in environment.
    private Properties hibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",
                       env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql",
                       env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql",
                       env.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.cache.use_query_cache",
                       env.getRequiredProperty(
                               "hibernate.cache.use_query_cache"));
        properties.put("hibernate.cache.use_second_level_cache",
                       env.getRequiredProperty(
                               "hibernate.cache.use_second_level_cache"));
        properties.put("hibernate.hbm2ddl.auto",
                       env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    /**
     * Transaction manager platform transaction manager.
     *
     * @param emf
     *         the emf
     *
     * @return the platform transaction manager
     */
    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf)
    {
        final JpaTransactionManager transactionManager =
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    /**
     * Exception translation persistence exception translation post processor.
     *
     * @return the persistence exception translation post processor
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
    {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}