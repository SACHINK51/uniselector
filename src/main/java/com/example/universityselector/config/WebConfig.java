package com.example.universityselector.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login"); // Assuming you have a login.html
        registry.addViewController("/questionnaire").setViewName("questionnaire");
        registry.addViewController("/universityList").setViewName("universityList");
    }
}
