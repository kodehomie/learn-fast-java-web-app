package org.justinhoang.conf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.time.Duration;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.justinhoang"})
public class WebMvcConf implements WebMvcConfigurer, ApplicationContextAware
{
    @Autowired
    private ApplicationContext applicationContext;

    public WebMvcConf()
    {
        super();
    }

    public void setApplicationContext(final ApplicationContext applicationContext) throws
                                                                                   BeansException
    {
        this.applicationContext = applicationContext;
    }

    /* ******************************************************************* */
    /*  GENERAL CONFIGURATION ARTIFACTS                                    */
    /*  Static Resources, i18n Messages, Formatters (Conversion Service)   */
    /* ******************************************************************* */

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry)
    {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/img/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/js/");

        registry.addResourceHandler("/img/*")
                .addResourceLocations("classpath:/img/");
        registry.addResourceHandler("/css/*")
                .addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/js/*")
                .addResourceLocations("classpath:/js/");

        registry.addResourceHandler("/img/")
                .addResourceLocations("classpath:/img/");
        registry.addResourceHandler("/css/")
                .addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/js/")
                .addResourceLocations("classpath:/js/");

        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:img/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:js/");

        registry.addResourceHandler("/img/*")
                .addResourceLocations("classpath:img/");
        registry.addResourceHandler("/css/*")
                .addResourceLocations("classpath:css/");
        registry.addResourceHandler("/js/*")
                .addResourceLocations("classpath:js/");

        registry.addResourceHandler("/img/")
                .addResourceLocations("classpath:img/");
        registry.addResourceHandler("/css/")
                .addResourceLocations("classpath:css/");
        registry.addResourceHandler("/js/")
                .addResourceLocations("classpath:js/");
    }

    @Bean
    public ResourceBundleMessageSource messageSource()
    {
        ResourceBundleMessageSource messageSource =
                new ResourceBundleMessageSource();
        messageSource.setBasename("Messages");
        return messageSource;
    }

    @Override
    public void addFormatters(final FormatterRegistry registry)
    {
        WebMvcConfigurer.super.addFormatters(registry);
        registry.addFormatter(dateFormatter());
    }

    @Bean
    public DateFormatter dateFormatter()
    {
        return new DateFormatter();
    }

    /* **************************************************************** */
    /*  THYMELEAF-SPECIFIC ARTIFACTS                                    */
    /*  TemplateResolver <- TemplateEngine <- ViewResolver              */
    /* **************************************************************** */

    @Bean
    public SpringResourceTemplateResolver templateResolver()
    {

        SpringResourceTemplateResolver templateResolver =
                new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/");
        templateResolver.setPrefix("WEB-INF/view/");
        templateResolver.setSuffix(".html");
        //        templateResolver.setSuffix(".jsp");
        // HTML is the default value, added here for the sake of clarity.
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // Template cache is true by default. Set to false if you want
        // templates to be automatically updated when modified.
        templateResolver.setCacheable(false);

        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine()
    {
        // SpringTemplateEngine automatically applies SpringStandardDialect and
        // enables Spring's own MessageSource message resolution mechanisms.
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
        // speed up execution in most scenarios, but might be incompatible
        // with specific cases when expressions in one template are reused
        // across different data types, so this flag is "false" by default
        // for safer backwards compatibility.
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver()
    {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("welcome").setViewName("welcome");
        registry.addViewController("userCreateForm")
                .setViewName("users-create-form");
        registry.addViewController("usersRead").setViewName("users-read");
        registry.addViewController("userUpdateForm")
                .setViewName("users-create-form");
    }

    //    @Override
    //    public void configureViewResolvers(ViewResolverRegistry registry) {
    //        registry.enableContentNegotiation(new MappingJackson2JsonView());
    //        registry.jsp();
    //    }

    //    @Override
    //    public void addResourceHandlers(ResourceHandlerRegistry registry)
    //    {
    //        WebMvcConfigurer.super.addResourceHandlers(registry);
    //        registry.addResourceHandler("/resources/**", "/static/**",
    //        "/static/*",
    //                                    "/img/*", "/css/*", "/js/*",
    //                                    "/img/**",
    //                                    "/css/**", "/js/**")
    //                .addResourceLocations("/View", "/img/", "/css/", "/js/",
    //                                      "classpath:/static/",
    //                                      "classpath:/img/",
    //                                      "classpath:/css/", "classpath:/js/")
    //                .setCacheControl(CacheControl.maxAge(Duration.ofDays
    //                (365)));
    //    }

}