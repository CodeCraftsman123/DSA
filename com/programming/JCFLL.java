package com.programming;
import java.util.LinkedList;

public class JCFLL
{
    public static void main(String[] args) {
        LinkedList<Integer>ll = new LinkedList<>();

        ll.add(3);
        ll.add(80);
        ll.add(3);
        System.out.println(ll);

//        int element = ll.get(0);
//        System.out.println(element);//3

        ll.remove(Integer.valueOf(3));
        System.out.println(ll);

    }
}
