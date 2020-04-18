package com.lizza;

/**
 * 1. 当一个接口初始化时, 并不要求其父接口都完成了初始化
 * 2. 只有在真正使用到父接口时(比如引用了父接口中定义的常量), 才会完成初始化
 */
public class ClassLoad_05 {

    public static void main(String[] args){
        System.out.println(Child_05.b);
    }
}

interface Parent_05 {
    int a = 5;
}

interface Child_05 extends Parent_05 {
    int b = 6;
}
