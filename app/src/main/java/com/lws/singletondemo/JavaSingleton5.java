package com.lws.singletondemo;

/**
 * 静态内部类式
 */
public class JavaSingleton5 {
    private JavaSingleton5() {

    }

    private static class Holder {
        private static JavaSingleton5 instance = new JavaSingleton5();
    }

    public JavaSingleton5 getInstance() {
        return Holder.instance;
    }
}
