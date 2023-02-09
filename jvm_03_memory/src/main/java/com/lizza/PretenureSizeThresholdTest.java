package com.lizza;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

/**
 * 测试 -XX:PretenureSizeThreshold 参数
 * 参数含义: 超过该参数设定值的对象, 直接在老年代分配
 *
 * 堆初始/最大: 104857600
 * eden: 52428800
 * jvm 参数
 -XX:+PrintCommandLineFlags
 -XX:+PrintGCDetails
 -XX:+PrintGCTimeStamps
 -XX:+PrintGCApplicationStoppedTime
 -XX:+PrintGCApplicationConcurrentTime
 -XX:+PrintHeapAtGC
 -Xms100m
 -Xmx100m
 -Xmn50m
 -XX:+UseConcMarkSweepGC
 -XX:SurvivorRatio=8

 */
public class PretenureSizeThresholdTest {

    /**
     * 不开启 -XX:PretenureSizeThreshold 参数, 对象的分配都在 eden 区, 只要能装的下
     * 装不下时, 会发生 ygc
     * jvm 参数

     -XX:+PrintCommandLineFlags
     -XX:+PrintFlagsFinal
     -XX:+PrintGCDetails
     -XX:+PrintGCTimeStamps
     -XX:+PrintGCApplicationStoppedTime
     -XX:+PrintGCApplicationConcurrentTime
     -XX:+PrintHeapAtGC
     -Xms100m
     -Xmx100m
     -Xmn50m
     -XX:+UseConcMarkSweepGC
     -XX:SurvivorRatio=8

     */
    @Test
    public void test1() throws Exception {
        // 10mb, 10485760
        byte[] array = new byte[10 * 1024 * 1024];
        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
            System.out.println(memoryPoolMXBean.getName() + "  总量:" + memoryPoolMXBean.getUsage().getCommitted()/1024 + "   使用的内存:" + memoryPoolMXBean.getUsage().getUsed()/1024);
        }
    }

    /**
     * 开启 -XX:PretenureSizeThreshold 参数, 超过会直接分配到 old 区
     * jvm 参数

     -XX:+PrintCommandLineFlags
     -XX:+PrintGCDetails
     -XX:+PrintGCTimeStamps
     -XX:+PrintGCApplicationStoppedTime
     -XX:+PrintGCApplicationConcurrentTime
     -XX:+PrintHeapAtGC
     -Xms100m
     -Xmx100m
     -Xmn50m
     -XX:+UseConcMarkSweepGC
     -XX:SurvivorRatio=8
     -XX:PretenureSizeThreshold=10

     */
    @Test
    public void test2() throws Exception {
        // 10mb, 10485760
        byte[] array = new byte[10 * 1024 * 1024];
        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
            System.out.println(memoryPoolMXBean.getName() + "  总量:" + memoryPoolMXBean.getUsage().getCommitted()/1024 + "   使用的内存:" + memoryPoolMXBean.getUsage().getUsed()/1024);
        }
    }
}
