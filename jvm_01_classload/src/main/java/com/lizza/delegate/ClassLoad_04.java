package com.lizza.delegate;

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
        System.out.println(loader);
        String url = "com/lizza/ClassLoad_03.class";
        Enumeration<URL> resources = loader.getResources(url);
        while (resources.hasMoreElements()) {
            URL element = resources.nextElement();
            System.out.println(element);
        }
        ClassLoader loader1 = ClassLoad_04.class.getClassLoader();
        System.out.println(loader1);
    }
}
