package com.lizza;

/**
 * 1. 每个类加载器都有自己的命名空间，命名空间由该加载器及所有父类加载器所加载的类组成
 * 2. 在同一个命名空间中，不会出现类的完整名字（包括类的包名）完全相同的两个类
 * 3. 在不同的命名空间，可能会出现类的完整名字（包括类的包名）完全相同的两个类
 * 4. 示例解释
 *    1. clazz_1和clazz_2由同一个类加载器加载, 同一个类加载器, 在相同的命名空间下, 同一个类只会被加载一次
 *    2. clazz_2和clazz_3由同不同的类加载器加载, 在相同的命名空间下, 不同的类加载器, 同一个类会被加载多次
 */
public class NameSpace_1 {

    public static void main(String[] args) throws Exception {
        String path = "/Users/lizza/Desktop/";
        CustomClassLoader_2 classLoader = new CustomClassLoader_2(path);
        Class<?> clazz_1 = classLoader.loadClass("com.lizza.ClassLoader_01");
        Class<?> clazz_2 = classLoader.loadClass("com.lizza.ClassLoader_01");
        System.out.println("clazz_1 == clazz_2 ? " + clazz_2.equals(clazz_1));
        CustomClassLoader_2 classLoader_1 = new CustomClassLoader_2(path);
        Class<?> clazz_3 = classLoader_1.loadClass("com.lizza.ClassLoader_01");
        System.out.println("clazz_2 == clazz_3 ? " + clazz_3.equals(clazz_2));
    }
}
