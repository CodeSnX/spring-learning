## orm模板
### 一、结构
##### 1. Spring JDBC 的xml配置版（Forum、post）
##### 2. Spring JDBC 的注解配置版
##### 3. Mybatis的xml配置版
##### 4. Mybatis的注解配置版
##### 5. Spring Data JPA的xml配置版
##### 6. Spring Data JPA的注解配置版

### 二、实例
##### 1. Spring JDBC的xml配置版
```
<context:annotation-config/>
    <context:component-scan base-package="com.soft1851.orm.config"/>
    <context:property-placeholder location="db.properties"/>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init">
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="initialSize" value="8"/>
    </bean>
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>
```
##### 2. Spring JDBC的注解配置版
```
 @Bean
    public DruidDataSource dataSource() {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/db_java_basic?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        source.setUsername("root");
        source.setPassword("root");
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

```