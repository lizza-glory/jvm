package com.lizza;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * 查看打印不同的类加载器的加载路径及文件
 * 1. 启动类加载器 System.getProperty("sun.boot.class.path")
 * 2. 扩展类加载器 System.getProperty("java.ext.dirs")
 * 3. 系统/应用类加载器 System.getProperty("java.class.path")
 */
public class ClassLoader_03 {

    public static void main(String[] args) throws IOException {
        Arrays.asList(System.getProperty("sun.boot.class.path")
                .split(":"))
                .forEach(System.out::println);
        System.out.println("----------");
        Arrays.asList(System.getProperty("java.ext.dirs")
                .split(":"))
                .forEach(System.out::println);
        System.out.println("----------");
        Arrays.asList(System.getProperty("java.class.path")
                .split(":"))
                .forEach(System.out::println);

    }
}
