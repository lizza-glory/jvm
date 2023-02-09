package com.lizza.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示 OOM
 */
public class OOMTests {

    /**
     * 堆
     -Xms2m
     -Xmx2m
     -XX:+HeapDumpOnOutOfMemoryError
     -XX:HeapDumpPath=/Users/lizza/Desktop/
     -Xloggc:/Users/lizza/Desktop/gc.log
     */
    @Test
    public void test1() throws Exception {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }

    /**
     * 模拟StackOverflowError(SOF)
     -Xss200k
     -XX:+HeapDumpOnOutOfMemoryError
     -XX:HeapDumpPath=/Users/lizza/Desktop/
     -Xloggc:/Users/lizza/Desktop/gc.log
     */
    @Test
    public void test2() throws Exception {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2();
    }

    /**
     *
     * 模拟方法区(元空间, Meta Space)产生内存溢出
     -XX:MaxMetaspaceSize=10m
     -XX:+HeapDumpOnOutOfMemoryError
     -XX:HeapDumpPath=/Users/lizza/Desktop/
     -Xloggc:/Users/lizza/Desktop/gc.log
     */
    @Test
    public void test3() throws Exception {
        for (;;) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMTests.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(object, method, param, proxy) ->
                    proxy.invokeSuper(object, param)
            );
            Object o = enhancer.create();
        }
    }
}
