## IOC模块
### 一、构成
#### 1. xml配置版
#### 2. 注解配置版

### 二、实例
##### 1. xml配置版实例：
- 定义：
```
<bean id="student" class="com.soft1851.ioc.entity.Student">
    <property name="name" value="颜子皓" />
    <property name="phone" ref="phone" />
    <property name="phones">
        <list>
           <ref bean="phone" />
        </list>
    </property>
</bean>
```
- main方法中测试：
``` 
  ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
  User user = (User) ac.getBean("user");
```
- 测试类中测试:
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/beans.xml")
public class StudentTest {
    @Autowired
    private Student student;

    @Test
    public void test() {
        System.out.println(student);
    }
}
```
##### 2.注解版配置示例
- 定义：
```
@Configuration
public class AppConfig {

    @Bean
    public Student student(){
        return new Student();
    }
}
```
- main方法中测试：
```
 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JDbcConfig.class);
 //scan手动扫包
 ctx.scan("com.soft1851.ioc.config");
 Student student = ctx.getBean("student") 
``` 
- 测试类中测试：

### 三、注意点
##### 1.xml配置版中依赖注入有两种方法：
一是通过构造器注入，即
```
<constructor-arg>
    <set>
         <ref bean="phone" />
         <ref bean="phone1" />
    </set>
</constructor-arg>
```
而是通过set方法注入，即
```
<property name="name" value="颜子皓" />
```
或
```
<bean id="phone" class="com.soft1851.ioc.entity.Phone" p:name="诺基亚" p:price="9.99" />
```
##### 2. 注解版配置
在config注解类中头部一定要有@Configuration注解