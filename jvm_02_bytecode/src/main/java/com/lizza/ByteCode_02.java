package com.lizza;

/**
 * 分析字节码结构
 */
public class ByteCode_02 {

    String s = "hello";

    private int x = 10;

    public static int y = 20;

    public static void main(String[] args){
        ByteCode_02 byteCode_02 = new ByteCode_02();
        byteCode_02.setX(8);
        y = 28;
    }

    public void setX(int x) {
        this.x = x;
    }
}
