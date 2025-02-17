package com.programming;
import java.util.Arrays;

public class MajorityElementUsingDivideAndConquer
{
    public static boolean flag = true;

    public static boolean isLastElementMajority(int[] A,int possibleMajority)
    {
        int numberOfOccurrences = 0;
        for(int element:A)
        {
            if(element == possibleMajority)
                numberOfOccurrences++;
        }

        if(numberOfOccurrences > (A.length / 2))
            return true;

        return false;
    }

    public static int findMajorityElement(int[] A,int[] B,int indexForB)
    {
        if(A.length == 0 ||(indexForB==0 && !flag))
            return Integer.MIN_VALUE;
        else if(A.length == 1)
            return A[0];
        else
        {
            if(flag)
            {
                flag = false;
                if(A.length%2 == 1)
                {
                    if(MajorityElementUsingDivideAndConquer.isLastElementMajority(A,A[A.length - 1]))
                        return A[A.length-1];
                    else
                    {
                        B = new int[(A.length-1)/2];
                        for(int i = 0 ; i < A.length -1 ;i+=2)
                        {
                            if(A[i] == A[i+1])
                                B[indexForB++] = A[i];
                        }
                    }
                }
                else
                {
                    B = new int[A.length / 2];
                    for(int i = 0; i < A.length  ; i+=2)
                    {
                        if(A[i] == A[i+1])
                            B[indexForB++] = A[i];
                    }
                }
            }

            if(indexForB%2 == 1)//Odd elements in array B
            {
                if(MajorityElementUsingDivideAndConquer.isLastElementMajority(A,B[indexForB-1]))
                    return B[indexForB-1];
                else
                {
                    int[] C = new int[(B.length-1)/2];
                    int indexForC = 0;
                    for(int i = 0 ; i < indexForB - 1 ; i+=2)
                        if(B[i] == B[i+1])
                            C[indexForC++] = B[i];
                    return findMajorityElement(A,C,indexForC);
                }
            }
            else//Even elements in array B
            {
                int[] C = new int[B.length/2];
                int indexForC = 0;
                for(int i = 0 ; i < indexForB ; i+=2)
                    if(B[i] == B[i+1])
                        C[indexForC++] = B[i];
                return findMajorityElement(A,C,indexForC);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] A = {1,1,2,2,3,1,1,3,3};
        int[] B = A;
        int indexForB = 0;

        int majorityElement = MajorityElementUsingDivideAndConquer.findMajorityElement(A,B,indexForB);

        if(majorityElement == Integer.MIN_VALUE)
            System.out.println("No majority element in "+Arrays.toString(A));
        else
            System.out.println("Majority element:"+majorityElement);
    }
}
