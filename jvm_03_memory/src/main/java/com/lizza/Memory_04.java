package com.lizza;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 模拟方法区(元空间, Meta Space)产生内存溢出
 * -XX:MaxMetaspaceSize=10m: 设置元空间大小为固定大小, 5m
 */
public class Memory_04 {

    public static void main(String[] args) throws InterruptedException {
        for (;;) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Memory_04.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(object, method, param, proxy) ->
                proxy.invokeSuper(object, param)
            );
            Object o = enhancer.create();
            System.out.println(o.getClass());
        }
    }
}