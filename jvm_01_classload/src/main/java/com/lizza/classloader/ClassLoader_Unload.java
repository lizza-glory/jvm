package com.lizza.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器卸载
 * 1. 使用jvm参数: XX:+TraceClassUnloading
 */
public class ClassLoader_Unload extends ClassLoader {

    /** 类加载器名称 **/
    private String classLoaderName;

    /** 扩展名 **/
    private String fileExtension = ".class";

    /** .class文件路径 **/
    private String path;

    public ClassLoader_Unload(String classLoaderName, String path) {
        super();    // 将系统类加载器作为该类加载器的父加载器
        this.path = path;
        this.classLoaderName = classLoaderName;
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
}

class Unload_Test {

    public static void main(String[] args) throws Exception {
        ClassLoader_Unload loader = new ClassLoader_Unload("loader", "/Users/lizza/Desktop/");
        Class<?> clazz = loader.loadClass("com.lizza.classloader.ClassLoader_01");
        System.out.println("Class Loader: " + clazz.getClassLoader());
        Thread.sleep(12000);
        loader = null;
        clazz = null;
        System.gc();
    }
}
