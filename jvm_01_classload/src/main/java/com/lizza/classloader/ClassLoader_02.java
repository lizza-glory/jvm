package com.lizza.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-05-05
 */
public class ClassLoader_02 {

    public static void main(String[] args) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String url = "com/lizza/ClassLoader_01.class";
        Enumeration<URL> resources = loader.getResources(url);
        while (resources.hasMoreElements()) {
            URL element = resources.nextElement();
            System.out.println(element);
        }

    }
}
