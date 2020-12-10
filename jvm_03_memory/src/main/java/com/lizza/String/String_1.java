package com.lizza.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 无限制创建String, 验证元空间和堆会内存溢出
 * JVM参数:
 * -Xms2m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./logs -Xloggc:gc.log
 */
public class String_1 {

    public static void main(String[] args){
        List<Object> list = new ArrayList<>();
    	while (true) {
//            String s = new String("hello");
            list.add(new Object());
        }
    }
}
