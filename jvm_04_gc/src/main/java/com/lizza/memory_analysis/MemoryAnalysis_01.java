package com.lizza.memory_analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 内存分析, 3 种
 *
 * 1. 利用 jmap 分析内存
 */
public class MemoryAnalysis_01 {

    public static void main(String[] args) throws IOException {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new One());
        }
        System.in.read();
    }
}

class One {
    /** 1MB **/
    private byte[] data = new byte[1024 * 1024];
}

class Two {
    /** 2MB **/
    private byte[] data = new byte[2 * 1024 * 1024];
}

class Three {
    /** 3MB **/
    private byte[] data = new byte[3 * 1024 * 1024];
}