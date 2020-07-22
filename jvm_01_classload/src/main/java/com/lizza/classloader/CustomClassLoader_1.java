package com.lizza.classloader;

import java.io.*;

/**
 * 自定义类加载器
 * 1. 继承ClassLoader
 * 2. 重写两个构造器分别去调用父类的构造器
 * 3. loadClassData(String name)方法加载二进制文件
 * 4. findClass(String name), 在findClass中调用父类的defineClass方法获取Class对象
 * 问题: 目前这个自定义的类加载器还不能加载类
 * 原因:
 * 1. com.lizza1.ClassLoader_01类位于CLASSPATH下
 * 2. 双亲委托机制导致类加载器加载类的时候会委托给父类加载器去加载, 类加载器默认的父类加载器是系统类加载器
 */
public class CustomClassLoader_1 extends ClassLoader {

    /** 扩展名 **/
    private String fileExtension = ".class";

    /** 类加载器名称 **/
    private String classLoaderName = this.getClass().getSimpleName();

    public CustomClassLoader_1() {
        super();    // 将系统类加载器作为该类加载器的父加载器
    }

    public CustomClassLoader_1(ClassLoader parent) {
        super(parent);  // 显示指定该类加载器的父加载器
    }

    public Class findClass(String name) {
        byte[] bytes = this.loadClassData(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassData(String name) {
        byte[] result = null;
        String url = name.replace("", "/");
        InputStream is = null;
        ByteArrayOutputStream os = null;

        try {
            is = new FileInputStream(url + fileExtension);
            os = new ByteArrayOutputStream();
            int ch = 0;

            while (-1 != (ch = is.read())) {
                os.write(ch);
            }

            result = os.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    public static void main(String[] args) throws Exception {
        CustomClassLoader_1 classLoader = new CustomClassLoader_1();
        Class<?> clazz = classLoader.loadClass("com.lizza.classloader.ClassLoader_01");
        Object instance = clazz.newInstance();
        System.out.println(instance.getClass().getClassLoader());
    }
}
