package com.programming;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class JCFQueue
{
    public static void main(String[] args)
    {
        Queue<Integer>queue1 = new ArrayDeque<>();
        System.out.println("Size of the queue:"+queue1.size());//0
        queue1.add(5);
        queue1.add(80);
        queue1.add(100);
        queue1.add(2000);
        System.out.println("Queue1:"+queue1);//[5, 80, 100, 2000]
        System.out.println("Size of the Queue:"+queue1.size());//4

        if(!queue1.isEmpty())
        {
            int removedElement = queue1.poll();
            System.out.println("Removed Element:" + removedElement);
            System.out.println("Queue after removing element:"+queue1);//[80, 100, 2000]
            System.out.println("Size of the queue:"+queue1.size());//3
        }

        if(!queue1.isEmpty())
        {
            int peekElement = queue1.peek();
            System.out.println("Peek Element:"+peekElement);//80
            System.out.println("Queue after showing peek element:"+queue1);
            System.out.println("Size of the queue:"+queue1.size());//3
        }


    }
}
