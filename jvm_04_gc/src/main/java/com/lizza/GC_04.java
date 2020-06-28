package com.lizza;

/**
 * JVM参数设置
 * -verbose:gc                      查看GC的详情
 * -Xmx200m                         堆空间最大值为200M
 * -Xmn50m                          新生代空间50M
 * -XX:TargetSurvivorRatio=60       设置一个阈值, 当Survivor空间中的使用率超过阈值时, 重新计算MaxTenuringThreshold的值
 * -XX:MaxTenuringThreshold=3       设置一个阈值, 当对象的年龄超过该阈值时, 对象会晋升到老年代
 * -XX:+PrintTenuringDistribution   打印各年龄段的对象占用字节
 * -XX:+PrintGCDetails              打印GC详情
 * -XX:+PrintGCDateStamps           打印GC时间戳
 * -XX:+UseConcMarkSweepGC          使用CMS收集器(老年代)
 * -XX:+UseParNewGC                 使用ParNew收集器(新生代)
 *
 * TargetSurvivorRatio, MaxTenuringThreshold阈值动态调节策略
 * 1. TargetSurvivorRatio表示Survivor空间使用率阈值, 当Survivor空间使用率超过该阈值时, JVM
 *    会重新计算MaxTenuringThreshold的值
 * 2. MaxTenuringThreshold表示对象年龄的阈值, 当Survivor空间中对象的年龄超过该阈值时, 对象会
 *    会直接晋升到老年代
 */
public class GC_04 {

    public static void main(String[] args) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];

        method();
        Thread.sleep(1000);
        System.out.println(">>> Step 1");

        method();
        Thread.sleep(1000);
        System.out.println(">>> Step 2");

        method();
        Thread.sleep(1000);
        System.out.println(">>> Step 3");

        method();
        Thread.sleep(1000);
        System.out.println(">>> Step 4");

        byte[] byte_3 = new byte[1024 * 1024];
        byte[] byte_4 = new byte[1024 * 1024];
        byte[] byte_5 = new byte[1024 * 1024];

        method();
        Thread.sleep(1000);
        System.out.println(">>> Step 5");

        method();
        Thread.sleep(1000);
        System.out.println(">>> Step 6");

        System.out.println(">>> Finished!");
    }

    private static void method() {
        for (int i = 0; i < 40; i++) {
            byte[] array = new byte[1024 * 1024];
        }
    }
}
