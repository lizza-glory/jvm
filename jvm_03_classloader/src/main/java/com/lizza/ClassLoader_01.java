package com.lizza;

/**
 * 数组类加载器
 * 1. 数组类型的类没有类加载器, 但是jvm会动态的创建一个类加载器
 * 2. 当调用Class.getClassLoader()时会返回数组元素的类加载器
 * 3. 基本类型没有类加载器
 */
public class ClassLoader_01 {

    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("------");
        ClassLoader_01[] classLoader_01s = new ClassLoader_01[2];
        System.out.println(classLoader_01s.getClass().getClassLoader());
        System.out.println("------");
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
    }
}
