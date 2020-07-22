package com.lizza.classloader;

import sun.reflect.Reflection;

/**
 * 获取ClassLoader的途径
 */
public class ClassLoader_13 {

    public static void main(String[] args) throws Exception{
        // 1. 获取当前类的类加载器
        ClassLoader loader1 = ClassLoader_13.class.getClassLoader();
        // 2. 获取当前线程上下文的ClassLoader
        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        // 3. 获取系统类加载器
        ClassLoader loader3 = ClassLoader.getSystemClassLoader();
        // 4. 获取调用者的类加载器(会抛出java.lang.InternalError)
        ClassLoader loader4 = Reflection.getCallerClass().getClassLoader();
        System.out.println(loader1);
        System.out.println(loader2);
        System.out.println(loader3);
        System.out.println(loader4);
    }
}
