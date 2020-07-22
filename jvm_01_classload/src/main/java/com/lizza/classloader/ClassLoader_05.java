package com.lizza.classloader;

/**
 * 验证扩展类加载器
 */
public class ClassLoader_05 {

    public static void main(String[] args) throws Exception {
        CustomClassLoader loader = new CustomClassLoader("loader");
        Class<?> clazz = loader.loadClass("com.lizza.classloader.ClassLoader_01");
        System.out.println(clazz.hashCode());
        System.out.println(clazz.getClassLoader());

    }
}
