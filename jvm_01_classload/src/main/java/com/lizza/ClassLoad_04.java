package com.lizza;

/**
 * 1. 当一个类被首次主动使用(7种主动使用情况的第1种)时, 会被初始化
 * 2. 不是首次主动使用的时候, 则不会再去初始化了
 * 3. 对于数组类型, 其类型是由jvm在运行期动态生成的, 表示为[Lxxx.xxx.xxx
 *    父类型为Object
 * 4. 对于数组, Java DOC将构成元素称之为Component, 实际就是将数组降低一个
 *    维度后得到的类型
 */
/**
 * 助记符:
 * 1. anewarray 表示创建一个引用类型(如类, 接口, 数组)的数组, 并将其压入栈顶
 * 2. newarray  表示创建一个指定的基本类型(如int, float)的数组, 并将其压入栈顶
 */
public class ClassLoad_04 {

    public static void main(String[] args){
        Child_04[] array = new Child_04[4];
        System.out.println(array.getClass());
        System.out.println("----------");
        Child_04 child_1 = new Child_04();
        System.out.println("----------");
        Child_04 child_2 = new Child_04();
    }
}

class Child_04 {

    static {
        System.out.println("Child_04 Static Code!");
    }
}