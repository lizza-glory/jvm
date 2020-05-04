package com.lizza;

class Client {
    static {
        System.out.println("Class Client");
    }
}

/**
 * 1. 调用ClassLoader类的loadClass方法加载一个类,并不是对类的主动使用, 不会导致类的初始化
 */
public class ClassLoad_02 {

    public static void main(String[] args) throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.lizza.Client");
        System.out.println(clazz);
        System.out.println("------");
        clazz = Class.forName("com.lizza.Client");
        System.out.println(clazz);
    }
}
