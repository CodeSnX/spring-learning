package com.soft1851.orm.app;

import com.soft1851.orm.config.AppConfig;
import com.soft1851.orm.entity.Forum;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ForumTest {
    public static void main(String[] args) {
        //生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        //scan手动扫包
        ctx.scan("com.soft1851.ioc.config");
        Forum forum = (Forum) ctx.getBean("forum");
        forum.setForumId(2);
        forum.setForumName("老颜");
        System.out.println(forum);
    }
}
