package com.lizza;

/**
 * -verbose:gc          打印gc的详细信息
 * -Xms20M              堆容量初始值
 * -Xmx20M              堆容量最大值
 * -Xmn10M              堆中新生代容量
 * -XX:+PrintGCDetails  打印GC的详细信息
 * -XX:SurvivorRatio=8  Eden空间容量和Survivor空间容量比例为8:1(Survivor默认有两个)
 */
public class GC_01 {

    public static void main(String[] args){
        /** 1MB **/
        int size = 1024 * 1024;

        byte[] allocation1 = new byte[2 * size];
        byte[] allocation2 = new byte[2 * size];
        byte[] allocation3 = new byte[2 * size];
        byte[] allocation4 = new byte[2 * size];
    }
}
