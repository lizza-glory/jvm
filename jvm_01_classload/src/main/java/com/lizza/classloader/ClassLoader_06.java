package com.lizza.classloader;

import java.lang.reflect.Method;

/**
 *
 */
public class ClassLoader_06 {

    public static void main(String[] args) throws Exception {
        CustomClassLoader loader1 = new CustomClassLoader("loader");
        CustomClassLoader loader2 = new CustomClassLoader("loader");
        Class<?> clazz1 = loader1.loadClass("com.lizza.classloader.User");
        Class<?> clazz2 = loader2.loadClass("com.lizza.classloader.User");
        /**
         * 输出true, 原因
         * 1. loader1和loader2在加载User类时都会委托给系统类加载器去加载,
         *    系统类加载器第一次加载完成后就不会再去加载了, 直接返回已加载好的class对象
         */
        System.out.println(clazz1 == clazz2);

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();
        Method method = clazz1.getMethod("setUser", Object.class);
        method.invoke(o1, o2);

    }
}

