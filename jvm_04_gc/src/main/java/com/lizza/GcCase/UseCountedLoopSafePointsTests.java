package com.lizza.GcCase;

import org.junit.Test;

import static java.lang.Thread.sleep;

/**
 * 测试因为循环中耗时操作, 导致到达安全点过慢, 最终导致 gc 耗时过长
 *
 * 模拟大循环, 导致 gc 耗时过高的问题; 两个线程模拟两种业务请求, 死循环模拟源源不断的业务请求
 * 线程 1: 死循环, 循环体中, 100 次循环, 循环中耗时操作, 每个操作耗时 50ms
 * 线程 2: 死循环, 循环体中, 创建 50kb 的对象
 */
public class UseCountedLoopSafePointsTests {

    int _1kb = 1024;
    int _50kb = 50 * 1024;
    int _1mb = 1024 * 1024;

    /**
     * jvm 参数
     -XX:+PrintCommandLineFlags
     -XX:+PrintGCDetails
     -XX:+PrintGCDateStamps
     -XX:+PrintGCApplicationStoppedTime
     -XX:+PrintHeapAtGC
     -Xms1024m
     -Xmx1024m
     -Xmn512m
     -XX:+UseConcMarkSweepGC
     */
    @Test
    public void test1() throws Exception {
        new Thread(() -> {
            while (true) {
                for (int i = 0; i < 100; i++) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "thread-1").start();
        new Thread(() -> {
            while (true) {
                byte[] bytes = new byte[_1kb];
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "thread-2").start();
        System.in.read();
    }
}
