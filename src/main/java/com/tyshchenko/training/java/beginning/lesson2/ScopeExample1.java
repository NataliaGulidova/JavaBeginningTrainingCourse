package com.tyshchenko.training.java.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class ScopeExample1 {
    public static void main(String[] args) {
        {
            int a = 10;
        }
        //System.out.println("a=" + a); //error: cannot find symbol a
    }
}
