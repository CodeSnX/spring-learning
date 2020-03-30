package com.soft1851.ioc.config;

import com.soft1851.ioc.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Student student(){
        return new Student();
    }
}
