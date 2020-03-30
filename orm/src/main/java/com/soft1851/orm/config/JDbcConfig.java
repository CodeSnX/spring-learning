package com.soft1851.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.orm.dao.ForumDao;
import com.soft1851.orm.dao.impl.ForumDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("com.soft1851.orm")
public class JDbcConfig {
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/db_java_basic?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        source.setUsername("root");
        source.setPassword("123456");
        //配置初始化大小、最小、最大
        source.setInitialSize(8);
        source.setMinIdle(1);
        source.setMaxActive(20);
        //配置获取连接等待超时的时间
        source.setMaxWait(60000);
        //配置间隔多久进行一次检测，检测需要关闭的空间连接，单位是毫秒
        source.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个连接在池中最小生成的时间，单位是毫秒
        source.setMinEvictableIdleTimeMillis(300000);
        //禁止自动提交，实现事务管理
        source.setDefaultAutoCommit(false);
        //设置连接池启用预处理事务集
        source.setPoolPreparedStatements(true);
        return source;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public ForumDao forumDao(JdbcTemplate jdbcTemplate) {
        return new ForumDaoImpl(jdbcTemplate);
    }
}
