package com.lizza;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-05-04
 */
public class ClassLoad_04 {

    public static void main(String[] args) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String url = "com/lizza/ClassLoad_03.class";
        Enumeration<URL> resources = loader.getResources(url);
        while (resources.hasMoreElements()) {
            URL element = resources.nextElement();
            System.out.println(element);
        }
    }
}
