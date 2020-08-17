package com.lizza.jmm;

/**
 * JMM: Java内存模型
 *      1. Java线程之间的共享变量存储在主内存中
 *      2. 每个Java线程都有私有的一块工作内存, 每个线程不能访问其他线程的工作内存
 *      3. 线程之间的通信是通过主内存来完成的
 * 验证volatile可见性
 *      1. volatile是简化版的synchronized, 保证了可见性, 有序性, 但不保证原子性
 */
public class Jmm_01 {

    volatile int number = 10;

    public void add() {
        this.number = 20;
    }

    public static void main(String[] args){
        Jmm_01 jmm_01 = new Jmm_01();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jmm_01.add();
            System.out.println("Thread: " + Thread.currentThread().getName() + ", Number is: " + jmm_01.number);
        }, "Thread-A").start();

        while (jmm_01.number == 10){}
        System.out.println("Main Thread Mission Is Over! " + Thread.currentThread().getName() + "Number is: " + jmm_01.number);
    }
}
