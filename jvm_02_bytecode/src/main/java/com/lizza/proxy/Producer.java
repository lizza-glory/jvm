package com.lizza.proxy;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-06-20
 */
public class Producer implements IProducer {

    @Override
    public void sale() {
        System.out.println("Sale Goods!");
    }
}
