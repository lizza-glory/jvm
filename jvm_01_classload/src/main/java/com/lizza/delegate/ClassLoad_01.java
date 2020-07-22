package com.lizza.delegate;

/**
 * 获取类的类加载器
 * 1. 基本类型的类加载器返回NULL(因为使用的是根类加载器)
 * 2.
 */
public class ClassLoad_01 {

    public static void main(String[] args) throws Exception{
        Class<?> clazz_1 = Class.forName("java.lang.String");
        System.out.println(clazz_1.getClassLoader());
        Class<?> clazz_2 = Class.forName("com.lizza.delegate.A");
        System.out.println(clazz_2.getClassLoader());

    }
}

class A {}
