package com.soft1851.ioc.app;

import com.soft1851.ioc.config.AppConfig;
import com.soft1851.ioc.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        acx.scan("com.soft1851.ioc.config");
        Student student = (Student) acx.getBean("student");
        student.setName("颜子皓");
        System.out.println(student);
    }
}
