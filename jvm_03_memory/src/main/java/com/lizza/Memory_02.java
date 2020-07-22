package com.lizza;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟StackOverflowError(SOF)
 * -Xss100k: 指定堆栈为100k
 */
public class Memory_02 {

    private int length;

    public int getLength() {
        return length;
    }

    public void test() {
        this.length++;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void main(String[] args) throws InterruptedException {
        Memory_02 memory_02 = new Memory_02();
        try {
            memory_02.test();
        } catch (Throwable t) {
            System.out.println(memory_02.getLength());
            t.printStackTrace();
        }
    }
}
