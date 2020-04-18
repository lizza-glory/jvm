package com.lizza;

/**
 * 1. 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 2. 本质上, 调用常量时并没有直接引用定义常量的类, 因此不会触发定义常量的类的初始化
 * 3. 注意: 这里指的是将常量存入到了ClassLoad_02的常量池中, 之后Sub与ClassLoad_02
 *         没有任何关系了, 甚至可以删除Sub的class文件
 */

/**
 * 助记符
 * 1. lbc 表示将int, float, String类型的常量值从常量池中推送至栈顶
 * 2. bipush 表示将单字节(127 ~ -128)的常量值推送至栈顶
 * 3. sipush 表示将短整型(32767 ~ -32768)的常量值推送至栈顶
 * 4. iconst_1 表示将int类型的1推送至栈顶, jvm内置了int类型的-1~5的助记符(iconst_m1~iconst_5)
 */
public class ClassLoad_02 {

    public static void main(String[] args){
        System.out.println(Child_02.i_2);
    }
}

class Child_02 {
    public static final String str = "Hello Word!";
    public static final short s = 127;
    public static final int i_1 = 128;
    public static final int i_2 = -1;
    public static final boolean b = false;

    static {
        System.out.println("Child_02 Static Block!");
    }
}
