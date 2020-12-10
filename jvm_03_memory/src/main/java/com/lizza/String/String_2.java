package com.lizza.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 无限制创建String, 验证元空间会内存溢出
 * JVM参数:
 * -Xms10m
 * -Xmx10m
 * -XX:MaxMetaspaceSize=10m
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=./logs
 * -Xloggc:gc.log
 * -verbose:gc
 * -XX:+PrintGCDateStamps
 */
public class String_2 {

    public static void main(String[] args){
        List<Object> list = new ArrayList<>();
        for (int i = 0; i >= 0 ; i++) {
            String s = "s" + i;
        }
    }
}
