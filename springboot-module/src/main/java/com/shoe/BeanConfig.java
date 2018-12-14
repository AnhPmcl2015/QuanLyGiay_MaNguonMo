package com.shoe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
//@EnableWebMvc
public class BeanConfig implements WebMvcConfigurer {

    @Value("${file.url}")
    private String urlRessource;
    @Value("${file.location}")
    private String locationResource;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(urlRessource).addResourceLocations(locationResource);
    }
}
