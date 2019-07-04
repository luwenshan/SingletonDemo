package com.lws.singletondemo;

/**
 * 饿汉式
 */
public class JavaSingleton1 {
    private static JavaSingleton1 instance = new JavaSingleton1();

    private JavaSingleton1() {

    }

    public static JavaSingleton1 getInstance() {
        return instance;
    }
}
