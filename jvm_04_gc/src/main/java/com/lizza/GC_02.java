package com.lizza;

/**
 * -XX:+PrintCommandLineFlags -version  打印jvm启动时的默认参数
 * -XX:PretenureSizeThreshold=4194304   设置一个阈值, 当新创建的对象的所需空间超过该阈值时, 直接在老年代进行对象分配(前提: 使用的是Serial GC)
 * -XX:+UseSerialGC  使用单线程(串行)垃圾收集器
 *
 * 1. 当一个对象创建时, 所需空间超过新生代的空间大小时, 会直接在老年代进行创建
 * 2. 当一个对象创建时, 所需空间超过老年代的空间大小时, JVM会尝试多次Minor GC和Full GC, 最后会出现OOM错误(使用Parallel GC)
 * 3. System.gc()   主动调用时, 表示告诉JVM需要执行一次Full GC, 但是何时执行, 是由JVM来决定的; 它的第二个重要意义是
 *    其他GC发生的时间点是在对象创建的时候, 如果空间不够了, 会进行GC, 而System.gc()可以在没有对象创建时, 主动触发GC
 */
public class GC_02 {

    public static void main(String[] args) throws InterruptedException {
        /** 1MB **/
        int size = 1024 * 1024;

        byte[] allocation1 = new byte[5 * size];

        Thread.sleep(1000000);
    }
}
