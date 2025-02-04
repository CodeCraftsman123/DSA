package com.programming;
import java.util.Scanner;

public class Ternary2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int marks = scanner.nextInt();
        String result = (marks>=33)?"pass":"fail";

        System.out.println("Result:"+result);

    }
}