package com.lizza.proxy;

import java.lang.reflect.Proxy;

/**
 * 使用jdk提供的Proxy实现动态代理
 * 1. 代理类和被代理类必须实现同一个接口
 * 2. 创建被代理类的实例
 * 3. 利用Proxy.newProxyInstance()方法创建代理类的实例
 * 4. 在InvocationHandler中进行方法增强
 */
public class Client {

    public static void main(String[] args){
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IProducer producer = new Producer();
        IProducer proxyInstance = (IProducer) Proxy.newProxyInstance(
                Producer.class.getClassLoader(),
                Producer.class.getInterfaces(),
                (proxy, method, params) -> {
                    System.out.println("Before Sale!");
                    Object result = method.invoke(producer, params);
                    System.out.println("After Sale!");
                    return result;
                });
        proxyInstance.sale();
    }
}
