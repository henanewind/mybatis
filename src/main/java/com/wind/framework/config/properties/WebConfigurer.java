package com.wind.framework.config.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述：
 *
 * @auther: zjf
 * @sine: 1.0
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/blog/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
