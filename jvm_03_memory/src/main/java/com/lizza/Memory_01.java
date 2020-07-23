package com.lizza;

import java.util.ArrayList;
import java.util.List;
/**
 * 模拟OutOfMemoryError
 * -Xms2m: 最小堆内存2m
 * -Xmx2m: 最大堆内存2m
 * -XX:+HeapDumpOnOutOfMemoryError: 发生OOM时储存错误文件
 * -XX:HeapDumpPath=/Users/lizza/Desktop/: 发生OOM时, dump文件存储位置
 * -Xloggc:/Users/lizza/Desktop/gc.log: 发生GC时, gc文件的存储位置
 */
public class Memory_01 {

    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        for(;;) {
            list.add(new Object());
//            System.gc();
//            Thread.sleep(1000);
        }
    }
}
