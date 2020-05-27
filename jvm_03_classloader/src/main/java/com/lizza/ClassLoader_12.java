package com.lizza;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 分析示例的代码在执行时, 底层是如何运作的(类加载的所有知识点)
 * 预习
 * 1. 类的加载
 *    1. 由于com.mysql.jdbc.Driver是第三方jar, 但是接口是jdk本身定义的, 按照类加载
 *       双亲委派的机制, 是不能够加载com.mysql.jdbc.Driver第三方jar的, 所以利用上下文
 *       加载器可以打破双亲委派机制的限制
 *    2. Class.forName()方法在加载类时, 默认使用的是类的调用者的类加载器, 默认类加载器是
 *       AppClassLoader, 所以可以加载CLASSPATH下的jar
 * 2. 类的连接
 * 3. 类的初始化
 *    1. 当调用DriverManager.getConnection()方法时, 会导致类的初始化(原因: 调用类的静态
 *       方法, 属于对类的主动使用, 会导致类的初始化)
 */
public class ClassLoader_12 {

    public static void main(String[] args) throws Exception{
        // 使用指定的类加载器(ExtClassLoader)加载MySQL驱动时, 会抛出ClassNotFoundException
        // 原因: ExtClassLoader无法加载CLASSPATH下的jar
//        Class.forName("com.mysql.jdbc.Driver", false, ClassLoader_12.class.getClassLoader().getParent());
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
}
