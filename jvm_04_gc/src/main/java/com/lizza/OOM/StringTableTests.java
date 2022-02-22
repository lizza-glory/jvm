package com.lizza.OOM;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * java 8 中 StringTable 是放在堆中的, 本次需要测试因为 String 对象创建过多
 * 导致 OOM
 * JVM 参数配置如下
 * -Xmx1m                                               最大堆内存
 * -Xms1m                                               初始堆内存
 * -Xmn1m                                               新生代堆内存大小
 * -XX:+PrintGCDetails                                  打印 GC 日志
 * -XX:+PrintGCDateStamps                               打印 GC 时间
 * -XX:-UseGCOverheadLimit                              1.6 新增的特性, gc 回收垃圾时, 会预测是否需要提前 OOM, 假如 98%的 GC
 *                                                      只回收了 2% 的垃圾, 那么就需要提前 OOM 了
 * -XX:+PrintStringTabIeStat1stIcs                      查看字符串常量池的相关信息
 * -XX:+HeapDumpOnOutOfMemoryError                      OOM 时 dump 堆内存
 * -XX:HeapDumpPath=/Users/lizza/Desktop/heap.hprof     GC 日志
 * -XX:+PrintFlagsFinal                                 打印 JVM 参数
 *
 */
public class StringTableTests {

    @Test
    public void test1() {
        Set<String> set = new HashSet<>();
        while (true) {
            String s = UUID.randomUUID().toString();
            set.add(s.intern());
        }
    }
}
