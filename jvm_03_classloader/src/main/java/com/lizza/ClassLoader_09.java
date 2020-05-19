package com.lizza;

import sun.misc.Launcher;

/**
 * 1. 内建于jvm的启动类加载器会加载==java.lang.ClassLoader==以及其他Java平台类
 * 2. 当jvm启动时，一块特殊的机器码会运行，它会加载扩展类加载器和系统类加载器，这块特殊的机器码就是启动类加载器（Bootstrap）
 * 3. 启动类加载器不是Java类，而其他加载器是Java类，启动类加载器是特定于平台的机器指令，启动类加载器负责开启整个加载过程的开启
 * 4. 所有类加载器（除了启动类加载器）都被实现为Java类，而启动类加载器负责开启第一个Java类加载器的加载
 * 5. 启动类加载器还负责加载jre正常运行时的组件，包括java.lang包，java.util包
 */
public class ClassLoader_09 {

    public static void main(String[] args) throws Exception {
        // ClassLoader的类加载器为启动类加载器
        System.out.println(ClassLoader.class.getClassLoader());
        // 验证AppClassLoader和ExtClassLoader的类加载器为启动类加载器
        System.out.println(Launcher.class.getClassLoader());
    }
}

