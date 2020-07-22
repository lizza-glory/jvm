package com.lizza.classload;

/**
 * 1. 类的准备阶段: 静态变量会被赋予默认的初始值
 * 2. 类的初始化阶段: 静态变量会被赋予正确的初始值
 */
public class ClassLoad_06 {

    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
    	System.out.println("count_1: " + Singleton.count_1);
    	System.out.println("count_2: " + Singleton.count_2);
    }

}

class Singleton {

    public static int count_1 = 1;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        count_1 ++;
        count_2 ++;
    }

    /** 注意count_2的位置: 在类的准备阶段, 静态变量被赋予默认值; 初始化阶段, 静态变量被赋予正确的值 **/
    public static int count_2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}