package com.programming;
import java.util.Scanner;

public class PalindromeStringOrNot
{

    public static boolean checkPalindrome(String str)
    {
        int start = 0, end = str.length() - 1;
        while(start < end)
        {
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println("String:\""+str+"\" is Palindrome?:"+PalindromeStringOrNot.checkPalindrome(str));


    }
}
