package com.programming;

public class Recursion2
{
    public static int calFact(int n)
    {
        if(n<=1)
            return 1;

        return calFact(n-1)*n;
    }

    public static int calSum(int n)
    {
        if(n <=1 )
            return 1;

        return n+calSum(n-1);
    }

    public static int calFibonacci(int n)
    {
        if(n==0 || n==1)
            return n;

        return calFibonacci(n-1)+calFibonacci(n-2);
    }

    public static boolean isSorted(int[] arr,int i)
    {
        if(i == arr.length - 1)
            return true;
        if(arr[i]>arr[i+1])
            return false;

        return isSorted(arr,i+1);
    }

    public static void main(String[] args)
    {
//        int n = 4;
//        int answer = calFact(n);
//        System.out.println(n+"!="+answer);

//        int ans = calSum(5);
//        System.out.println(ans);

        int ans = calFibonacci(6);
        System.out.println("6th number in fibonacci series:"+ans);

        int[] arr = {1,2,4,5,3};
        if(isSorted(arr,0))
            System.out.println("The given array is non-decreasing sorted");
        else
            System.out.println("The given array is not sorted in non-decreasing order");

    }
}