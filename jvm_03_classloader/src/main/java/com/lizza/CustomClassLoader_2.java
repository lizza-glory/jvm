package com.lizza;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * 修改: 从指定路径加载.class文件
 * 1. 第一次执行(未删除CLASSPATH下的ClassLoader_01.class文件), 类加载器是系统类加载器
 * 2. 删除CLASSPATH下的ClassLoader_01.class文件后再次执行, 类加载器是CustomClassLoader_2
 * 原因:
 * 1. 未删除CLASSPATH下的ClassLoader_01.class文件, 根据双亲委派原则, 类加载器会去委托父类加载器去加载ClassLoader_01类
 *    而自定义类加载器的父类加载器是AppClassLoader(系统类加载器), AppClassLoader会在CLASSPATH下寻找并加载ClassLoader_01类
 * 2. 删除了ClassLoader_01类后, AppClassLoader在CLASSPATH下寻找加载ClassLoader_01类, 加载失败后,
 *    返回给自定义的类加载器CustomClassLoader_2进行类加载
 * 注意:
 */
public class CustomClassLoader_2 extends ClassLoader {

    /** 扩展名 **/
    private String fileExtension = ".class";

    /** 类加载器名称 **/
    private String classLoaderName = this.getClass().getSimpleName();

    /** .class文件路径 **/
    private String path;

    public CustomClassLoader_2(String path) {
        super();    // 将系统类加载器作为该类加载器的父加载器
        this.path = path;
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
            is = new FileInputStream(path + url + fileExtension);
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
        String path = "/Users/lizza/Desktop/";
        CustomClassLoader_2 classLoader = new CustomClassLoader_2(path);
        Class<?> clazz = classLoader.loadClass("com.lizza.ClassLoader_01");
        Object instance = clazz.newInstance();
        System.out.println(instance.getClass().getClassLoader());
    }
}
