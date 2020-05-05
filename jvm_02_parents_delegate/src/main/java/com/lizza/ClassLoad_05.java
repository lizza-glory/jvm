package com.lizza;

/**
 *
 */
public class ClassLoad_05 {

    public static void main(String[] args){
        System.out.println(ClassLoad_05.class.getClassLoader());
        // String类位于rt.jar中, 需要根类加载器去加载
        System.out.println(String.class.getClassLoader());

    }
}
