package com.lizza.gc_01_log;

/**
 * GC日志常用参数设置
 * -XX:+PrintGC                     输出简要GC日志
 * -XX:+PrintGCDetails              输出详细GC日志
 * -verbose:gc                      输出简要GC日志, 同-XX:+PrintGC
 * -Xloggc:gc.log                   输出GC日志到文件
 * -XX:+PrintGCTimeStamps           输出GC的时间戳(以JVM启动到当期的总时长的时间戳形式)
 * -XX:+PrintGCDateStamps           输出GC的时间戳(以日期的形式，如 2013-05-04T21:53:59.234+0800)
 * -XX:+PrintHeapAtGC               在进行GC的前后打印出堆的信息
 * -XX:+PrintTenuringDistribution   打印各年龄段的对象占用字节
 * -XX:+PrintReferenceGC            打印年轻代各个引用的数量以及时长
 *
 * jvm参数
 * -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+PrintHeapAtGC
 */
public class GC_04 {

    public static void main(String[] args){
        byte[] array = new byte[1024 * 1024 * 20];
    }
}
