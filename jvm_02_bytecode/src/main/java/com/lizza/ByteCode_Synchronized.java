package com.lizza;

/**
 * synchronized详解
 */
public class ByteCode_Synchronized {

    /**
     * synchronized修饰实例方法, 是对对象进行加锁
     */
    public synchronized void m1() {

    }

    /**
     * 1. synchronized修饰代码块, 其本质是对对象的代码块进行加锁, 底层使用
     *    monitorenter和monitorexit进行控制锁的加载和释放
     * 2. 对于synchronized来讲, 锁的入口只有一个, 即monitorenter只出现一次
     *    但是, 锁的出口则会有多个, 因为如果代码发生异常, 需要程序去主动释放锁
     */
    public void m2(Object obj) {
        synchronized (obj) {

        }
    }

    /**
     * synchronized修饰静态方法, 表示对对象所对应的Class对象进行加锁
     */
    public synchronized static void m2() {

    }
}
