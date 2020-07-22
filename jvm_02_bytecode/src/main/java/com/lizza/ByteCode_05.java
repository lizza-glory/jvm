package com.lizza;

/**
 * 方法的静态分派
 * GrandPa g1 = new Father();
 * 1. 以上代码, g1的静态类型是GrandPa, 而g1的实际类型是Father
 * 2. 结论: 变量的静态类型不会发生变化, 而实际类型则可以发生变化(多态的一种体现);
 * 3. 变量的实际类型是在运行期确定的
 *
 * 方法重载: 是一种静态行为, 在编译器就可以确定
 *
 */
public class ByteCode_05 {

    public void test (GrandPa grandPa) {
        System.out.println("GrandPa");
    }

    public void test (Father father) {
        System.out.println("Father");
    }

    public void test (Son son) {
        System.out.println("Son");
    }

    public static void main(String[] args){
        GrandPa g1 = new Father();
        GrandPa g2 = new Son();
        ByteCode_05 byteCode_05 = new ByteCode_05();
        byteCode_05.test(g1);
        byteCode_05.test(g2);

    }

}

class GrandPa {

}

class Father extends GrandPa {

}

class Son extends Father {

}