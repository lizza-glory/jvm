package com.lizza;

/**
 * -verbose:gc                      查看GC详情
 * -Xms20M                          堆容量初始值
 * -Xmx20M                          堆容量最大值
 * -Xmn10M                          堆中新生代容量
 * -XX:+PrintGCDetails              打印GC的详细信息
 * -XX:SurvivorRatio=8              Eden空间容量和Survivor空间容量比例为8:1(Survivor默认有两个)
 * -XX:+PrintCommandLineFlags       打印JVM启动参数
 * -XX:MaxTenuringThreshold=5       设置一个阈值, 当进行GC时, 对象经历的GC次数如果超过了该阈值, 该对象会直接进入老年代
 *                                  该参数的默认值是15, CMS中默认值是6, G1中默认值是15(在JVM中, 该阈值使用4个bit表示
 *                                  所以最大值是1111, 即15)
 * -XX:+PrintTenuringDistribution   打印不同年龄对象的情况
 *
 * 1. 经历了多次GC后, 存活的对象在From Survivor和To Survivor之间来回移动; 而这里面的一个前提是这两个空间有足够的大小
 * 来存放这些数据; 在GC算法中, 会计算每个对象年龄的大小, 如果达到这某个年龄后发现总大小已经大于了Survivor空间的50%, 那么
 * 这时就需要调整阈值, 不能再等到完成默认的15次GC后才进行晋升, 否则会导致Survivor空间不足, 所以需要调整阈值, 让这些存活的
 * 对象尽快完成晋升
 */
public class GC_03 {

    public static void main(String[] args){
        /** 1MB **/
        int size = 1024 * 1024;

        byte[] allocation1 = new byte[2 * size];
        byte[] allocation2 = new byte[2 * size];
        byte[] allocation3 = new byte[2 * size];
        byte[] allocation4 = new byte[2 * size];
    }
}




