package com.lizza;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 上下文类加载器的使用
 * 1. 使用模式：获取->使用->还原
 * 2. 伪代码
 *    ClassLoader loader = Thread.currentThread().getContextClassLoader();
 *    try {
 *        Thread.currentThread().setContextClassLoader(targetClassLoader);
 *        method();
 *    } finally {
 *        Thread.currentThread().setContextClassLoader(loader);
 *    }
 * 3. method()中调用Thread.currentThread().getContextClassLoader()获取当前线程的上下文类加载器来做一些事情
 * 4. 如果一个类是由加载器A加载，那么这个类的依赖也是由该类加载器加载的（前提是该类未被加载过）
 * 5. ContextClassLoader就是为了补充Java的类委托机制的不足
 * 6. 当高层提供了统一的接口供低层去实现，同时又需要在高层加载（或实例化）低层的类时，就必须通过上下文类加载器来帮助高层的ClassLoader找到并加载该类
 */
public class ClassLoader_11 {

    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("Driver: " + driver + ", ClassLoader: " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程的上下文类加载器: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器: " + loader.getClass().getClassLoader());
    }
}
