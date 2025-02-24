package com.programming;
import java.util.HashSet;

public class CountDistinctElements
{
    public static void main(String[] args)
    {
        HashSet<Integer>hashset = new HashSet<>();
        int[] array = {4,3,2,5,6,7,3,4,2,1};

        for(int element:array)
            hashset.add(element);

        System.out.println("Total number of unique element:"+hashset.size());
    }
}
