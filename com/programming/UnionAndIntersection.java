package com.programming;
import java.util.HashSet;

public class UnionAndIntersection
{
    public static void main(String[] args)
    {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};

        HashSet<Integer>hashset1 = new HashSet<>();
        HashSet<Integer>union = new HashSet<>();
        HashSet<Integer>intersection = new HashSet<>();

        for(int element:arr1)
            hashset1.add(element);

        for(int element:arr2)
        {
            if(hashset1.contains(element))
                intersection.add(element);
        }

        for(int element:arr2)
            hashset1.add(element);

        for(int element:hashset1)
            union.add(element);

        System.out.println("Union:"+union);
        System.out.println("Intersection:"+intersection);

    }
}
