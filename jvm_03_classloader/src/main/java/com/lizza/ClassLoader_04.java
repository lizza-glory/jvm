package com.lizza;

/**
 * 验证启动类加载器加载自定义的class文件
 * 1. 将ClassLoader_01.class文件拷贝到启动类加载器的加载路径下:/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/classes
 * 2. 运行程序验证双亲委派机制
 */
public class ClassLoader_04 {

    public static void main(String[] args) throws Exception {
        CustomClassLoader loader = new CustomClassLoader("loader");
        Class<?> clazz = loader.loadClass("com.lizza.ClassLoader_01");
        System.out.println(clazz.hashCode());
        System.out.println(clazz.getClassLoader());

    }
}
