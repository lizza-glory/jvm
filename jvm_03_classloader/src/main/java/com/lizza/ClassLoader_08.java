package com.lizza;

/**
 * 指定扩展类加载器的类加载路径
 * 1. java -Djava.ext.dirs=./ com.lizza.ClassLoader_08
 *      1. 执行完成后, 发现都是由系统类加载器加载
 *      2. 扩展类加载器加载jar包中的文件, 所以需要将ClassLoader_01打成一个jar包
 * 2. 再次执行java -Djava.ext.dirs=./ com.lizza.ClassLoader_08 发现ClassLoader_01
 *    由扩展类加载器加载
 */
public class ClassLoader_08 {

    static {
        System.out.println("ClassLoader_08 Initialize");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(ClassLoader_08.class.getClassLoader());
        System.out.println(ClassLoader_01.class.getClassLoader());
    }
}

