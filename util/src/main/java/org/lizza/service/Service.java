package org.lizza.service;

import org.lizza.util.Util;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-29
 */
public class Service {

    private Util util = new Util();

    public void handle() {
        util.util();
        System.out.println("Service handle do something. ClassLoader: " + Service.class.getClassLoader());
    }
}
