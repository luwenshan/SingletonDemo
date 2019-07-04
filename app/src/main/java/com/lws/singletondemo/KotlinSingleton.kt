package com.lws.singletondemo

/**
 * 饿汉式
 */
object KotlinSingleton1

/**
 * 懒汉式（非线程安全）
 */
class KotlinSingleton2 private constructor() {
    companion object {
        private var instance: KotlinSingleton2? = null
            get() {
                if (field == null) {
                    field = KotlinSingleton2()
                }
                return field
            }

        /**
         * 不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法
         */
        fun get(): KotlinSingleton2 {
            return instance!!
        }
    }
}

/**
 * 线程安全的懒汉式（同步锁）
 */
class KotlinSingleton3 private constructor() {
    companion object {
        private var instance: KotlinSingleton3? = null
            get() {
                if (field == null) {
                    field = KotlinSingleton3()
                }
                return field
            }

        /**
         * 同步锁
         */
        @Synchronized
        fun get(): KotlinSingleton3 {
            return instance!!
        }
    }
}

/**
 * 双重校验锁式（Double Check）
 */
class KotlinSingleton4 private constructor() {
    companion object {
        val instance: KotlinSingleton4 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { KotlinSingleton4() }
    }
}

/**
 * 静态内部类式
 */
class KotlinSingleton5 private constructor() {
    companion object {
        var instance = Holder.holder
    }

    private object Holder {
        val holder = KotlinSingleton5()
    }
}

/**
 * 带参数
 */
class KotlinSingleton6 private constructor(private val property: Int) {
    companion object {
        @Volatile
        private var instance: KotlinSingleton6? = null

        fun getInstance(property: Int) =
            instance ?: synchronized(this) {
                instance ?: KotlinSingleton6(property).also { instance = it }
            }
    }
}
