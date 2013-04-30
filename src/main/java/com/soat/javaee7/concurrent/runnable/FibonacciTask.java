package com.soat.javaee7.concurrent.runnable;

/**
 *  This task print the first 10 Fibonacci numbers to the console. 
 *  Runnable interface cannot return any value
 *
 * @author Julien Sadaoui
 */
public class FibonacciTask implements Runnable
{   
    @Override
    public void run() {
        for (int i = 0 ; i <= 10 ; i++) {
            System.out.print(fib(i));
            if (i != 10)  System.out.print(" ");
        }
    }
    
    /**
     *  A recursive function for computing the nth Fibonacci number.
     */
    static long fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
}
