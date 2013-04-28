/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soat.javaee7.concurrent;

/**
 *
 * @author Julien
 */
public class MyRunnable implements Runnable
{
    
    public static long fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++)
            System.out.print(i + ": " + fib(i) + " ");
    }
}
