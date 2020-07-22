package com.lizza.classloader;

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
 *    3. Class.forName(String className)默认会立即初始化所加载的类, 所以com.mysql.jdbc.Driver
 *       会立即被初始化
 *    4. com.mysql.jdbc.Driver符合Java SPI的规范, 所以类路径下/META-INF/services/java.sql.Driver
 *       文件中定义的实现类默认都会被加载, 而且即使不写Class.forName("com.mysql.jdbc.Driver")也可以加载
 *       com.mysql.jdbc.Driver
 * 2. 类的连接
 * 3. 类的初始化
 *    1. 当调用DriverManager.getConnection()方法时, 会导致类的初始化(原因: 调用类的静态
 *       方法, 属于对类的主动使用, 会导致类的初始化)
 *    2. isDriverAllowed(Driver driver, ClassLoader classLoader)方法, 调用了Class.forName
 *       来判断加载了Driver类的命名空间是否相同, 即判断是否是加载了调用类的类加载器加载的Driver
 */
public class ClassLoader_12 {

    public static void main(String[] args) throws Exception{
        // 使用指定的类加载器(ExtClassLoader)加载MySQL驱动时, 会抛出ClassNotFoundException
        // 原因: ExtClassLoader无法加载CLASSPATH下的jar
//        Class.forName("com.mysql.jdbc.Driver", false, ClassLoader_12.class.getClassLoader().getParent());
//        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
}
