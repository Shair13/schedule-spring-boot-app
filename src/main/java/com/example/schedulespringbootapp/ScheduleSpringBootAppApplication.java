package com.example.schedulespringbootapp;

import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@SpringBootApplication
public class ScheduleSpringBootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleSpringBootAppApplication.class, args);
    }
    @Bean
    Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}


