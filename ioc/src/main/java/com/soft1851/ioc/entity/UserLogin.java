package com.soft1851.ioc.entity;

import java.util.Scanner;

public class UserLogin {
    private User user;

    //登录判断方法
    public boolean userLogin(User user) {
        if(("admin").equals(user.getAccount()) && ("111").equals(user.getPassword())){
            return true;
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "user=" + user +
                '}';
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入账号： ");

    }
}
