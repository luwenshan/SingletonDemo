package com.lws.singletondemo;

/**
 * 双重校验锁式（Double Check）
 */
public class JavaSingleton4 {
    private JavaSingleton4() {

    }

    /**
     * 加上 volatile 是为了可见性和防止指令重排
     */
    private volatile static JavaSingleton4 instance;

    public static JavaSingleton4 getInstance() {
        if (instance == null) {
            synchronized (JavaSingleton4.class) {
                if (instance == null) {
                    instance = new JavaSingleton4();
                }
            }
        }
        return instance;
    }
}
