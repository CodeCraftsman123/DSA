package com.programming;
import java.util.LinkedHashSet;

public class Recursion3
{
    public static int firstOccurrence(int[] array,int i, int key)
    {
        if(i == array.length)
            return -1;
        if(array[i] == key)
            return i;

        return firstOccurrence(array,i+1,key);
    }

    public static int lastOccurrence(int[] array,int i,int key)
    {
        if(i == -1)
            return -1;
        if(array[i] == key)
            return i;

        return lastOccurrence(array,i-1,key);
    }

    //TC:O(n)
    public static int calPower(int x, int n,int i,int ans)
    {
        if(i == n)
            return ans * x;

        ans *= x;

        return calPower(x,n,i+1,ans);
    }

    public static int calPower(int x,int n)
    {
        if(n==0)
            return 1;

        return x * calPower(x,n-1);
    }

    //TC:O(log n)
    public static int calPowerOpt(int a,int n)
    {
        if(n == 0)
            return 1;
        int halfPower = calPowerOpt(a,n/2);
        int halfPowerSq = halfPower * halfPower;

        if(n%2 == 1)
            halfPowerSq = a * halfPowerSq;

        return halfPowerSq;
    }

    public static String noDuplicatesHashSet(String s)
    {
        StringBuilder sb = new StringBuilder();
        LinkedHashSet<Character>lhs = new LinkedHashSet<>();

        for(char element:s.toCharArray())
        {
            if(element == ' ')
                sb.append(element);
            else if(!lhs.contains(Character.toUpperCase(element)) && !lhs.contains(Character.toLowerCase(element)))
            {
                lhs.add(element);
                sb.append(element);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args)
    {
//        int[] array = {8,3,6,9,5,10,2,5,3};
//        int firstIndex = firstOccurrence(array,0,5);
//        System.out.println(firstIndex);

//        int lastOccurrenceIndex = lastOccurrence(array,array.length-1,5);
//        System.out.println(lastOccurrenceIndex);//2^10 == 1024

//        int x, n ;
//        x = 5;
//        n=9;
//        int ans = calPowerOpt(x,n);
//        System.out.println(ans);//1953125

        String noDuplicateString = noDuplicatesHashSet("appnnacollege");
        System.out.println(noDuplicateString);//apncoleg







    }
}
