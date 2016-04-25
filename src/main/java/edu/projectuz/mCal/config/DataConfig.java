package edu.projectuz.mCal.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

@Configuration
public class DataConfig {
    @Bean
    public BeanPostProcessor persistanceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
