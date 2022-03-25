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

/**
 * The type Web mvc conf.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.justinhoang"})
public class WebMvcConf implements WebMvcConfigurer
{
    /**
     * Resolver internal resource view resolver.
     *
     * @return the internal resource view resolver
     */
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
}