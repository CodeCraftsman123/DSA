package com.programming;

public class Recursion1
{
    public static void printNumberAsc(int n)
    {
        if(n <= 0)
            return;

        printNumberAsc(n-1);
        System.out.println(n);
    }

    public static void printNumberDesc(int n)
    {
        if(n<=0)
            return;

        System.out.println(n);
        printNumberDesc(n-1);
    }

    public static void main(String[] args)
    {
        int n = 5;
        printNumberAsc(n);
//        printNumberDesc(n);
    }
}