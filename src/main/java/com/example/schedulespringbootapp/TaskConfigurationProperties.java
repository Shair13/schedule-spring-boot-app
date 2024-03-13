package com.example.schedulespringbootapp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("task")
public class TaskConfigurationProperties {

    private Template template;

    @Getter
    @Setter
    public static class Template {
        private boolean allowMultipleTasks;
    }
}
