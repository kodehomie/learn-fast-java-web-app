package org.justinhoang.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.justinhoang"})
public class WebMvcConf implements WebMvcConfigurer
{
    @Bean
    public InternalResourceViewResolver resolver()
    {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
        registry.addResourceHandler("/include/**")
                .addResourceLocations("/include/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/jsp/**").addResourceLocations("/jsp/");

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/resources/")
                .resourceChain(false).addResolver(new PathResourceResolver());
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/").resourceChain(false)
                .addResolver(new PathResourceResolver());
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/img/").resourceChain(false)
                .addResolver(new PathResourceResolver());
        registry.addResourceHandler("/include/**")
                .addResourceLocations("classpath:/include/")
                .resourceChain(false).addResolver(new PathResourceResolver());
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/js/").resourceChain(false)
                .addResolver(new PathResourceResolver());
        registry.addResourceHandler("/jsp/**")
                .addResourceLocations("classpath:/jsp/").resourceChain(false)
                .addResolver(new PathResourceResolver());
    }


    //
    //    @Bean
    //    public ResourceBundleMessageSource messageSource()
    //    {
    //        ResourceBundleMessageSource messageSource =
    //                new ResourceBundleMessageSource();
    //        messageSource.setBasename("Messages");
    //        return messageSource;
    //    }

    //    @Override
    //    public void addViewControllers(ViewControllerRegistry registry)
    //    {
    //        registry.addViewController("/")
    //                .setViewName("/WEB-INF/view/index");
    //        registry.addViewController("welcome").setViewName("welcome");
    //        registry.addViewController("userCreateForm")
    //                .setViewName("users-create-form");
    //        registry.addViewController("usersRead").setViewName("users-read");
    //        registry.addViewController("userUpdateForm")
    //                .setViewName("users-create-form");
    //        registry.addViewController("jsp").setViewName("jsp/sample");
    //    }
    //
    //    @Bean
    //    public ViewResolver internalResourceViewResolver()
    //    {
    //        InternalResourceViewResolver resolver =
    //                new InternalResourceViewResolver();
    //        resolver.setPrefix("/WEB-INF/view");
    //        resolver.setSuffix(".jsp");
    //        resolver.setViewNames("view/*");
    //        resolver.setOrder(2);
    //        return resolver;
    //    }

}