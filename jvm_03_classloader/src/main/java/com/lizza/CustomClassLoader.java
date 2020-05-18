package com.lizza;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class CustomClassLoader extends ClassLoader {

    /** 扩展名 **/
    private String fileExtension = ".class";

    /** 类加载器名称 **/
    private String classLoaderName;

    /** .class文件路径 **/
    private String path;

    public CustomClassLoader(String classLoaderName) {
        super();    // 将系统类加载器作为该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public CustomClassLoader(String classLoaderName, String path) {
        super();    // 将系统类加载器作为该类加载器的父加载器
        this.classLoaderName = classLoaderName;
        this.path = path;
    }

    public CustomClassLoader(ClassLoader parent, String path) {
        super(parent);    // 自定义父加载器
        this.path = path;
    }

    public void setPath(String path) {
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
}
