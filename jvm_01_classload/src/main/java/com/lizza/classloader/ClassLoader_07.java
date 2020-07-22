package com.lizza.classloader;

import java.lang.reflect.Method;

/**
 * 不同类加载器的命名空间的类的可见性
 * 1. 删除CLASSPATH下com.lizza.User.class文件
 * 2. 将CLASSPATH下com文件夹移至Desktop
 */
/**
 * 双亲委托机制的优势
 * 1. 保证Java核心类库的安全: 双亲委托机制保证了Java的核心类库只会由启动类加载器加载, 不会存在
 *    多个版本, 相互之间也是可见的
 * 2. 保证了核心类不会被自定义类所替代
 * 3. 不同的类加载器可以提供不同的命名空间, 相互之间相互隔离, 不同的类加载器加载的类相互之间不可见
 */
/**
 * 1. 在运行期, 一个Java类是由该类的完全限定名(binary name)和用于加载该类的定义类加载器(defining loader)
 * 所共同决定的;
 * 2. 如果同样名字(即类的完全限定名相同)的类是由不同的类加载器加载, 即使是从相同的位置加载, 二进制文件
 * 相同, 最终加载后的类也是不同的
 */
public class ClassLoader_07 {

    public static void main(String[] args) throws Exception {
        CustomClassLoader loader1 = new CustomClassLoader("loader1", "/Users/lizza/Desktop/");
        CustomClassLoader loader2 = new CustomClassLoader("loader2", "/Users/lizza/Desktop/");

        Class<?> clazz1 = loader1.loadClass("com.lizza.classloader.User");
        Class<?> clazz2 = loader2.loadClass("com.lizza.classloader.User");

        /**
         * 输出false, 原因
         * 1. loader1和loader2在加载User类时都会委托给系统类加载器去加载,
         *    系统类加载器无法加载, 便一直向上委托给启动类加载器加载器, 启动类
         *    加载器无法加载, 委托给自定义类加载器
         * 2. 自定义类加载器尝试加载并且可以成功加载, 但是loader1和loader2是两个不同的类加载器
         *    故class对象不相同
         */
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1.getClassLoader());
        System.out.println(clazz2.getClassLoader());

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();
        System.out.println(o1);
        System.out.println(o2);
        Method method = clazz1.getMethod("setUser", User.class);
        method.invoke(o1, o2);

    }
}

