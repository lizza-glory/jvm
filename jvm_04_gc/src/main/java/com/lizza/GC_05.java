package com.lizza;

import java.util.Timer;

/**
 * 1. 进行Major GC之前是否会进行Minor GC
 * JVM参数设置
 * -verbose:gc                      查看GC的详情
 * -Xms10m                          堆空间初始值10M
 * -Xmx10m                          堆空间最大值10M
 * -Xmn5m                           新生代空间5M
 * -XX:MaxTenuringThreshold=1       设置一个阈值, 当对象的年龄超过该阈值时, 对象会晋升到老年代
 * -XX:+PrintTenuringDistribution   打印各年龄段的对象占用字节
 * -XX:+PrintGCDetails              打印GC详情
 * -XX:+PrintGCDateStamps           打印GC时间戳
 * -XX:+PrintHeapAtGC               在进行GC的前后打印出堆的信息
 *
 */
public class GC_05 {

    public static void main(String[] args) throws Exception {
        int size = 1024 * 1024;

        byte[] a1 = new byte[size];
        byte[] a2 = new byte[size];
        Thread.sleep(500);
    }
}
