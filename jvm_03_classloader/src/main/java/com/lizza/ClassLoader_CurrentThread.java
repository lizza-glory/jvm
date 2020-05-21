package com.lizza;

/**
 * 上下文类加载器
 */
public class ClassLoader_CurrentThread {

    public static void main(String[] args) {
        // 输出: AppClassLoader 原因: 在初始化SystemClassLoader时, 会将SystemClassLoader设置为线程的上下文类加载器
        System.out.println(Thread.currentThread().getContextClassLoader());
        // 输出: null 原因: Thread位于java.lang包下, 由启动类加载器负责加载
        System.out.println(Thread.class.getClassLoader());
    }
}
