package com.lizza.CMSGCLog;

/**
 * CMS收集器GC日志详解
 * jvm参数: -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
 */
public class CMS_01 {

    public static void main(String[] args){
        /** 1MB **/
        int size = 1024 * 1024;

        byte[] allocation1 = new byte[4 * size];
        System.out.println(">>> Step 1");
        byte[] allocation2 = new byte[4 * size];
        System.out.println(">>> Step 2");
        byte[] allocation3 = new byte[4 * size];
        System.out.println(">>> Step 3");
        byte[] allocation4 = new byte[2 * size];
        System.out.println(">>> Step 4");
    }
}
