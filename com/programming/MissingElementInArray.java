package com.programming;
import java.util.HashSet;
import java.util.Arrays;

public class MissingElementInArray//For N elements in array, the element should be from 1 to N.If any element is missing, that is the missing element.
{
    public static int hashingApproach(int[] arr)
    {
        HashSet<Integer>hashset = new HashSet<>();

        for(int element:arr)
            hashset.add(element);
        int value = 1;

        for(int i = 0; i < arr.length ; i++)
        {
            if(hashset.contains(value))
            {
                value++;
                continue;
            }

            return value;
        }

        return Integer.MIN_VALUE;
    }

    public static int mathsApproach(int[] arr)
    {
        /*
        sum2 = [1,2,3] = 6, sum1 = 10
         */
        int n = arr.length + 1;
        int sum1 = ((n*(n+1))/2);
        int sum2 = 0;
        for(int element:arr)
            sum2+= element;

        if(sum1-sum2 == (arr.length+1))
            return Integer.MIN_VALUE;

        return sum1-sum2;

    }

    
    public static void main(String[] args)
    {
        int[] arr = {1,4,5,3,6};
//        int value = MissingElementInArray.hashingApproach(arr);
//        if(value!=Integer.MIN_VALUE)
//            System.out.println("Missing value in the array"+Arrays.toString(arr)+":"+value);
//        else
//            System.out.println("There is no missing value in the array");

        int value = MissingElementInArray.mathsApproach(arr);
        if(value!=Integer.MIN_VALUE)
            System.out.println("Missing value in the array"+Arrays.toString(arr)+":"+value);
        else
            System.out.println("There is no missing element in the array");

    }
}
