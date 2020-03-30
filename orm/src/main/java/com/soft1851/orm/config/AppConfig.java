package com.soft1851.orm.config;

import com.soft1851.orm.entity.Forum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Forum forum() {
        return new Forum();
    }
}
