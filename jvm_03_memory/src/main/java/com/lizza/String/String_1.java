package com.lizza.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 无限制创建String, 验证堆会内存溢出
 * JVM参数:
 * -Xms2m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./logs -Xloggc:gc.log -verbose:gc -XX:+PrintGCDateStamps
 */
public class String_1 {

    public static void main(String[] args){
        List<Object> list = new ArrayList<>();
    	while (true) {
            String s = "hello";
            list.add(s);
        }
    }
}
