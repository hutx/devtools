package com.iquantex.devtools.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by hutx on 11:01 2018/11/22
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("*") //POST, GET, OPTIONS
                .allowedHeaders("x-requested-with")
                // .exposedHeaders("header1", "header2")
                .allowCredentials(true).maxAge(3600);
    }
}
