package com.lizza.classloader;

/**
 * 1. 子加载器加载的类可以访问父加载器加载的类
 * 2. 父加载器加载的类无法访问子加载器加载的类
 */
public class Zoo {

    public Zoo() {
        System.out.println("Zoo Is Loaded By: " + this.getClass().getClassLoader());
        new Cat();
    }

    public static void main(String[] args) throws Exception {
        CustomClassLoader loader = new CustomClassLoader("loader");
        Class<?> clazz = loader.loadClass("com.lizza.classloader.Zoo");
        /**
         * 1. 如果注释掉此行, Zoo和Cat不会被初始化, 仅仅是被jvm加载到内存中
         * 2. Zoo一定会被加载到内存中, Cat不会被加载到内存中
         */
//        Object instance = clazz.newInstance();
    }
}
