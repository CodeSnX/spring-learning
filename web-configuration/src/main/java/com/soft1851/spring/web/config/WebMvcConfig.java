package com.soft1851.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ComponentScan("com.soft1851.spring.web")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 配置视图解析器
     * @return SpringResourceTemplateResolver
     */
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver(){
        return new SpringResourceTemplateResolver();
    }

    @Bean
    public ITemplateResolver templateResolver(){
        springResourceTemplateResolver().setPrefix("classpath:/");
        springResourceTemplateResolver().setSuffix(".html");
        springResourceTemplateResolver().setTemplateMode(TemplateMode.HTML);
        springResourceTemplateResolver().setCharacterEncoding("UTF-8");
        return springResourceTemplateResolver();
    }

    @Bean
    public TemplateEngine templateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

}
