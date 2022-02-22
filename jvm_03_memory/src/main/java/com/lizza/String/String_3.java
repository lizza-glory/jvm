package com.lizza.String;

/**
 * 理解 String intern 方法
 */
public class String_3 {

    public static void main(String[] args){
        String s1 = "abc".intern();
        System.out.println(s1);
    }
}
