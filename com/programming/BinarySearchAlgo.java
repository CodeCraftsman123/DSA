package com.programming;
import java.util.LinkedList;

public class BinarySearchAlgo
{
    public static int applyBinarySearch(int[] array,int key)
    {
        int start = 0, end = array.length - 1;

        while(start <= end)
        {
            int mid = (start + end) / 2;

            if(key<array[mid])
                end = mid - 1;
            else if(key>array[mid])
                start = mid + 1;
            else if(array[mid] == key)
                return mid;

        }

        return -1;
    }


    public static void main(String[] args)
    {
//        int[] array = {1,2,3,4,5,6,7,8,10,10};
//        int key = 10;
//
//        int index = BinarySearchAlgo.applyBinarySearch(array,key);
//        System.out.println("Index:"+index);//2

        LinkedList<Integer>ll = new LinkedList<>();
        ll.add(3);
        System.out.println(ll);



    }
}