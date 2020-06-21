package com.lizza;

/**
 * 模拟死锁
 *
 */
public class Memory_03 {
    public static void main(String[] args){
        Object o1 = new Object();
        Object o2 = new Object();
        new Thread(() -> {
            synchronized (o1) {
                System.out.println("T1 得到了 o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("T1 得到了 o2");
                }
            }
        }, "T1").start();
        new Thread(() -> {
            synchronized (o2) {
                System.out.println("T2 得到了 o2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("T2 得到了 o1");
                }
            }
        }, "T2").start();
    }
}