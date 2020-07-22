package com.lizza.delegate;

/**
 * 1. ClassLoader.getSystemClassLoader()用来获取系统类加载器
 * 2. 在HotSpot中, 根类加载器使用null来标示
 */
public class ClassLoad_03 {

    public static void main(String[] args){
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);
        while (loader != null) {
            loader = loader.getParent();
            System.out.println(loader);
        }
    }
}
