package com.lws.singletondemo;

/**
 * 线程安全的懒汉式（同步锁）
 */
public class JavaSingleton3 {
    private JavaSingleton3() {

    }

    private static JavaSingleton3 instance;

    /**
     * synchronized 同步锁
     */
    public static synchronized JavaSingleton3 getInstance() {
        if (instance == null) {
            instance = new JavaSingleton3();
        }
        return instance;
    }
}
