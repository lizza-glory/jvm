package com.lizza;

/**
 *
 */
public class Cat {

    public Cat() {
        System.out.println("Cat Is Loaded By: " + this.getClass().getClassLoader());
    }
}
