package com.lws.singletondemo;

/**
 * 懒汉式（非线程安全）
 */
public class JavaSingleton2 {
    private JavaSingleton2() {

    }

    private static JavaSingleton2 instance;

    public static JavaSingleton2 getInstance() {
        if (instance == null) {
            instance = new JavaSingleton2();
        }
        return instance;
    }
}
