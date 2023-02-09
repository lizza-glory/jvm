package com.lizza.cpu;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class JStackTests {

    /**
     * 死循环
     */
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                System.out.println(System.currentTimeMillis());
            } 
        }, "thread-1").start();
        new Thread(() -> {
            System.out.println(2);
        }, "thread-2").start();   
    }

    /**
     * 大量元素 copy
     */
    @Test
    public void test2() throws Exception {
        int capacity = 1000000;
        Set<Integer> set = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            set.add(i);
        }
        while (true) {
            Set<Integer> newSet = new HashSet<>(set);
        }
    }

    @Test
    public void test3() throws Exception {
        System.in.read();
    }
}
