package com.lizza;

import javafx.scene.Parent;

/**
 * 1. 对于静态字段来讲, 只有直接定义了该字段的类才会被初始化;
 * 2. 当一个类被初始化时, 要求其父类必须初始化完成;
 * 3. -XX:+TraceClassLoading 用于追踪类的加载信息并打印出来;
 * 4. jvm 参数使用
 *    -XX:+<option> 表示开启option选项
 *    -XX:-<option> 表示关闭option选项
 *    -XX:<option>=<value> 表示将option的值设置为value
 */
public class ClassLoad_01 {

    public static void main(String[] args){
        System.out.println(Child_01.p_str);
    }
}

class Parent_01 {

    public static String p_str = "Hello World!";

    /** 类被初始化时, 静态代码块会被执行 **/
    static {
        System.out.println("Parent_01 Static Block!");
    }
}

class Child_01 extends Parent_01 {

    public static String c_str = "Welcome!";

    /** 类被初始化时, 静态代码块会被执行 **/
    static {
        System.out.println("Child_01 Static Block!");
    }
}
