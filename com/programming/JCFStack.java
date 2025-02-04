package com.programming;
import java.util.Stack;

public class JCFStack
{
    public static void main(String[] args) {
        Stack<Integer>stack = new Stack<>();

//        stack.push(3);
//        stack.push(80);
//        boolean stackIsEmpty = stack.isEmpty();
//        System.out.println("Stack is empty:"+stackIsEmpty);

        try
        {
            int stackPeek = stack.peek();
            System.out.println("Stack Peek:" + stackPeek);//80
        }
        catch(Exception e)
        {
            System.out.println("Stack is empty, cannot perform the peek operation");
        }

        int poppedElement = stack.pop();
        System.out.println("Popped Element:"+poppedElement);//80

        System.out.println("Stack:"+stack);//3

    }
}
