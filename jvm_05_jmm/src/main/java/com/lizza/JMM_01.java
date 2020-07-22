package com.lizza;

/**
 *
 */
public class JMM_01 {

    public static volatile int num;

    public static void increase() {
        num ++;
    }

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            }).start();
        }

        while (Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(num);
    }
}
