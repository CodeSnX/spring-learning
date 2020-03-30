package com.soft1851.orm.app;

import com.soft1851.orm.config.JDbcConfig;
import com.soft1851.orm.dao.ForumDao;
import com.soft1851.orm.entity.Forum;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DataTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(JDbcConfig.class);
        //scan手动扫包
        ctx.scan("com.soft1851.ioc.config");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        ForumDao forumDao = (ForumDao) ctx.getBean("forumDao");
        Forum forum = Forum.builder().forumName("123").build();
        forumDao.insert(forum);
    }
}
