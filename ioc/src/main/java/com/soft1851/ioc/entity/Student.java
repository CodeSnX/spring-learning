package com.soft1851.ioc.entity;

import java.util.List;

public class Student {
    private String name;
    private Phone phone;
    private List<Phone> phones;

    public Student() {
    }

    public Student(String name, Phone phone, List<Phone> phones) {
        this.name = name;
        this.phone = phone;
        this.phones = phones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
