package com.lizza;

/**
 * new关键字分析
 * 1. 为对象在堆上开辟内存空间
 * 2. 调用构造方法, 在堆上创建对象
 * 3. 将堆上对象的引用值返回
 *
 * 方法的动态分派
 *
 * invokevirtual字节码指令的多态查找流程
 * 1. 找到操作数栈顶的第一个元素它所指向的实际类型
 * 2. 找到对应的方法, 校验访问权限, 如果符合条件, 则返回
 * 3. 如果没有找到, 则从下向上继续查找
 *
 * 方法的重载(overload)和重写(overwrite)
 * 1. 方法重载是静态的, 是编译器行为
 * 2. 方法重写是动态的, 是运行期行为
 * 3. 方法重载是方法的静态分派过程, 方法重写是方法的动态分派过程
 *
 */
public class ByteCode_06 {

    public static void main(String[] args){
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        orange.test();
        apple.test();

        apple = new Orange();

        apple.test();
    }
}

class Fruit {

    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {

    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {

    @Override
    public void test() {
        System.out.println("Orange");
    }
}
