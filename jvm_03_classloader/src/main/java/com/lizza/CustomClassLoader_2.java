package com.lizza;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 修改: 从指定路径加载.class文件
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
        String url = name.replace(".", "/");
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
