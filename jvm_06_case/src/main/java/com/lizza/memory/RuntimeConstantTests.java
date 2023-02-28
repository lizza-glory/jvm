package com.lizza.memory;

import com.lizza.util.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量测试
 */
public class RuntimeConstantTests {

    public static final List<byte[]> NAME_LIST = new ArrayList<>();

    public static final int MB_1 = 1024 * 1024;

    /**
     * 名单大小约 80MB, 老年代 100MB, 新生代 100MB
     * 结论:
     * 逐渐分配内存时, 名单数据会在新生代先分配, 新生代无法存放时, 会发生 ygc, 将新生代中名单数据挪到老年代
     * 然后继续在新生代分配
     -XX:+PrintCommandLineFlags
     -XX:+PrintGCDetails
     -XX:+PrintGCDateStamps
     -XX:+PrintHeapAtGC
     -XX:+HeapDumpOnOutOfMemoryError
     -XX:HeapDumpPath=/Users/lizza/Desktop/
     -Xms200m
     -Xmx200m
     -Xmn100m
     -XX:+UseConcMarkSweepGC
     -XX:SurvivorRatio=8
     */
    @Test
    public void test1() throws Exception {
        Thread.sleep(10000);
        Logger.info("Start Allocate Memory ...");
        for (int i = 0; i < 80; i++) {
            NAME_LIST.add(new byte[MB_1]);
            Thread.sleep(1000);
        }
        System.in.read();
    }

    /**
     * 名单大小约 80MB, 老年代 100MB, 新生代 100MB
     * 结论:
     * 一次性分配 80MB 时, 会直接在老年代分配, CMS 会尝试进行 Major GC, 但是总是清理不了
     -XX:+PrintCommandLineFlags
     -XX:+PrintGCDetails
     -XX:+PrintGCDateStamps
     -XX:+PrintHeapAtGC
     -XX:+HeapDumpOnOutOfMemoryError
     -XX:HeapDumpPath=/Users/lizza/Desktop/
     -Xms200m
     -Xmx200m
     -Xmn100m
     -XX:+UseConcMarkSweepGC
     -XX:SurvivorRatio=8
     */
    @Test
    public void test2() throws Exception {
        Thread.sleep(10000);
        Logger.info("Start Allocate Memory ...");
        NAME_LIST.add(new byte[MB_1 * 80]);
        System.in.read();
    }

    /**
     * 名单大小约 80MB, 老年代 180MB, 新生代 20MB
     * 结论:
     * 逐渐分配内存, 新生代过小 + 晋升年龄设置过低, 会导致 ygc 频繁
     -XX:+PrintCommandLineFlags
     -XX:+PrintGCDetails
     -XX:+PrintGCDateStamps
     -XX:+PrintHeapAtGC
     -XX:+HeapDumpOnOutOfMemoryError
     -XX:HeapDumpPath=/Users/lizza/Desktop/
     -Xms200m
     -Xmx200m
     -Xmn20m
     -XX:+UseConcMarkSweepGC
     -XX:SurvivorRatio=8
     -XX:MaxTenuringThreshold=1
     */
    @Test
    public void test3() throws Exception {
        Thread.sleep(10000);
        Logger.info("Start Allocate Memory ...");
        for (int i = 0; i < 80; i++) {
            NAME_LIST.add(new byte[MB_1]);
            Thread.sleep(100);
        }
        System.in.read();
    }
}
