package com.lizza.classloader;

/**
 * 验证: 默认的上下文加载器是AppClassLoader
 * 原因: sun.misc.Launcher中, 在构造器中调用了 Thread.currentThread().setContextClassLoader(this.loader);
 * 对上下文类加载器进行了设置, 而this.loader就是AppClassLoader
 */
public class ClassLoader_10 implements Runnable {

    private Thread thread;

    public ClassLoader_10() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        ClassLoader loader = this.thread.getContextClassLoader();
        System.out.println("Class: " + loader.getClass());
        System.out.println("Parent: " + loader.getParent().getClass());
    }

    public static void main(String[] args){
        new ClassLoader_10();
    }
}

