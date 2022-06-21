package com.lizza.cms_gc_log;

/**
 * CMS调优实践
 * 模拟频繁GC
 * jvm参数: -Xms20m -Xmx20m -Xmn6m -XX:+PrintGCDetails -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
 */
public class CMS_02 {

    public static void m() {
        int size = 1024 * 1024;
        byte[] allocation1 = new byte[4 * size];
        System.out.println("-------------------");
        byte[] allocation2 = new byte[4 * size];
        System.out.println("*******************");
    }

    public static void main(String[] args){
    	while (true) {
    	    m();
    	    try { Thread.sleep(1500); } catch (Exception e) {}
        }
    }
}
