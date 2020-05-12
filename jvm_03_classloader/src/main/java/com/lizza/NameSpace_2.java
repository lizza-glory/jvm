package com.lizza;

/**
 * 双亲委派机制~自定义类加载器
 * 1. 自定义类加载器loader1和loader2分别去加载com.lizza.ClassLoader_01.class, 加载时会先委托父类
 *    加载器加载, 父类加载器是系统类加载器, 会在CLASSPATH下寻找加载, 加载失败后
 *    会返回让子类加载器loader1和loader2去加载
 * 2. 当loader2指定了父类加载器为loader1时, loader1加载完成后, loader2加载时
 *    会委托父类加载器loader1加载, loader1发现已经加载了, 便不再加载
 */
public class NameSpace_2 {

    public static void main(String[] args) throws Exception {
        String path = "/Users/lizza/Desktop/";
        CustomClassLoader loader1 = new CustomClassLoader("loader1", path);
        Class<?> clazz_1 = loader1.loadClass("com.lizza.ClassLoader_01");
        CustomClassLoader loader2 = new CustomClassLoader("loader2", path);
        Class<?> clazz_2 = loader2.loadClass("com.lizza.ClassLoader_01");
        System.out.println("clazz_1: " + clazz_1.getClassLoader());
        System.out.println("clazz_2: " + clazz_2.getClassLoader());
    }
}
