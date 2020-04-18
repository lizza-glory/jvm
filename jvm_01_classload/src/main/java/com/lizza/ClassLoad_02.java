package com.lizza;

/**
 * 1. 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 2. 本质上, 调用常量时并没有直接引用定义常量的类, 因此不会触发定义常量的类的初始化
 */
public class ClassLoad_02 {

    public static void main(String[] args){
        System.out.println(Sub.str);
    }
}

class Sub {
    public static final String str = "Hello Word!";

    static {
        System.out.println("Sub Static Block!");
    }
}
