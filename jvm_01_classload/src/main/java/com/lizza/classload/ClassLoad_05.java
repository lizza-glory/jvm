package com.lizza.classload;

import java.util.Random;

/**
 * 1. 初始化一个类不会初始化其父接口
 * 2. 初始化一个接口不会初始化父接口
 * 3. 只有在真正使用到父接口时(比如引用了父接口中定义的常量), 才会完成初始化
 * 4. 当一个类被初始化的时候, 它所实现的接口是不会被初始化的; 但是接口会被加载
 * 5. 当一个类的变量为常量时, 使用该常量, 不会导致该类被加载, 更不会被初始化
 */
public class ClassLoad_05 {

    public static void main(String[] args){
        System.out.println(Child_05.a);
    }
}

interface Parent_05 {
    int a = new Random().nextInt(10);
    public static Thread thread = new Thread(){
        {
            System.out.println("Parent_05 inited!");
        }
    };
}

class Child_05 implements Parent_05 {
    public static int b = 6;
}
