package com.tyshchenko.training.java.beginning.lesson2;

/**
 * @author Alexander Tyshchenko.
 */
public class ScopeExample2 {
    public static void main(String[] args) {
        {
            {
                int a =10;
                {
                    System.out.println("a = " + a);
                }
            }
        }
    }
}


