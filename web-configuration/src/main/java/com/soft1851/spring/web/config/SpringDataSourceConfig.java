package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xgp
 */
@Configuration
@ComponentScan("com.soft1851.spring.web")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class SpringDataSourceConfig {

//    @Value("${jdbc.driverClassName}")
//    private String driverClassName;
//
//    @Value("${jdbc.url}")
//    private String jdbcUrl;
//
//    @Value("${jdbc.username}")
//    private String username;
//
//    @Value("${jdbc.password}")
//    private String password;

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
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
        source.setDefaultAutoCommit(true);
        //设置连接池启用预处理事务集
        source.setPoolPreparedStatements(true);
        return source;
    }

    /**
     *jdbcTemplate模板配置
     *
     * @return JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    /**
     * 装配事务管理器
     *
     * @return DataSourceTransactionManager
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource){
        return new DataSourceTransactionManager(druidDataSource);
    }

}

