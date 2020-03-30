package com.soft1851.ioc.app;

import com.soft1851.ioc.entity.User;
import com.soft1851.ioc.entity.UserLogin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserLoginTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserLogin userLogin = (UserLogin) ac.getBean("userLogin");
        User user = (User) ac.getBean("user");
        user.setAccount("admin");
        user.setPassword("1234");
    }
}
