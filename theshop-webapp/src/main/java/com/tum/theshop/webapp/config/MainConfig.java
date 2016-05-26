package com.tum.theshop.webapp.config;

import com.tum.theshop.webapp.data.properties.GoogleProperties;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class MainConfig {

    @Bean
    public GoogleProperties googleProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/google.properties.template"));
        propertiesFactoryBean.afterPropertiesSet();
        GoogleProperties googleProperties = new GoogleProperties();
        googleProperties.setProperties(propertiesFactoryBean.getObject());
        return googleProperties;
    }
}
