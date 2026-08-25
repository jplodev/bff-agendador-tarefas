package com.jpdev.bffagendadortarefas.infrastructure.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeingConfig {

    @Bean
    public FeignError feignError(){
        return new FeignError();
    }

}
