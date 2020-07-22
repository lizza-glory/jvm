package com.lizza.classloader;

/**
 * 当前类加载器(current ClassLoader)
 * 1. 每个类加载器都会使用自己的类加载器(即加载自身的类加载器)来去加载其他类(所依赖的类)
 * 2. 如果A引用了B, 那么加载了A的类加载器就会尝试去加载B, 前提是B尚未被加载
 *
 * 线程上下文类加载器(context ClassLoader)
 * 1. 线程上下文类加载器是从jdk 1.2引入的, 类Thread的getContextClassLoader()和
 *    setContextClassLoader(ClassLoader cl)分别用来获取和设置线程上下文类加载器
 * 2. 如果没有通过setContextClassLoader(ClassLoader cl)方法来设置上下文类加载器
 *    则会继承加载该线程的父线程的类加载器来作为上下文类加载器
 * 3. Java应用启动时的初始线程的上下文类加载器是系统类加载器, 在线程中运行的代码可以通过
 *    该类加载器来加载类和资源
 *
 * 双亲委派模型的缺陷
 * 1. 在双亲委派模型中, 子类加载器加载的类可以使用父类加载器加载的类, 而父类加载器加载的类
 *    却无法使用子类加载器加载的类; 这样的规则导致SPI(Service Provider Interface)机制
 *    下, 第三方jar包无法被启动类加载器使用, 比如java.sql.Driver接口
 * 2. 解决方案: 线程上下文类加载器
 *
 * 线程上下文类加载器的作用及重要性
 * 1. 父类加载器可以使用线程上下文类加载器(通过Thread.currentThread().getContextClassLoader()获取得到)
 *    加载的类; 这就改变了父类加载器不能使用子类加载器加载的类或没有直接父子关系的类加载器加载的类, 即弥补了双亲
 *    委派模型的缺陷
 * 2. 线程上下文类加载器即当前类加载器
 * 3. 在双亲委派模型下, 类加载时有下至上的, 即底层的类加载器会委托上层类加载器来加载;
 *    但是对于SPI, 有些接口是Java核心库提供的, 而Java核心课是由启动类加载器加载的,
 *    接口的实现来自于不同的jar包(不同厂商实现), 启动类加载器不会加载其他来源的jar包,
 *    传统的双亲委派模型无法满足SPI要求; 但是通过给当前线程设置上下文类加载器, 可以通过
 *    上下文类加载器去加载接口的实现类
 */
public class ClassLoader_CurrentThread {

    public static void main(String[] args) {
        // 输出: AppClassLoader 原因: 在初始化SystemClassLoader时, 会将SystemClassLoader设置为线程的上下文类加载器
        System.out.println(Thread.currentThread().getContextClassLoader());
        // 输出: null 原因: Thread位于java.lang包下, 由启动类加载器负责加载
        System.out.println(Thread.class.getClassLoader());
    }
}
