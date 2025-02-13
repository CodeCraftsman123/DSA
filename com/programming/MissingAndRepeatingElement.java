package com.programming;
import java.util.ArrayList;
import java.util.Arrays;

public class MissingAndRepeatingElement
{
    public static ArrayList<Integer> bruteForceApproach(int[] arr)
    {
        int counter = 1;
        int missingElement, repeatingElement;
        missingElement = repeatingElement = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++)
        {
            boolean elementFound = false;
            for(int element:arr)
            {
                if(counter == element && elementFound)
                {
                    repeatingElement = element;
                    break;
                }
                if(counter == element)
                {
                    elementFound = true;
                }
            }
            if(!elementFound)
                missingElement = counter;
            if(missingElement!=Integer.MIN_VALUE && repeatingElement!=Integer.MIN_VALUE)
                break;
            counter++;
        }

        return new ArrayList<>(Arrays.asList(missingElement,repeatingElement));
    }

    public static ArrayList<Integer>hashingApproach(int[] arr)
    {
        int[] count = new int[arr.length + 1];
        int missingElement,repeatingElement;
        missingElement = repeatingElement = Integer.MIN_VALUE;
        Arrays.fill(count,0);

        for(int i = 0 ; i < arr.length ; i++)
        {
            count[arr[i]]++;
        }

        for(int i = 1 ; i <= arr.length ; i++)
        {
            if(count[i] == 0)
                missingElement = i;
            if(count[i] == 2)
                repeatingElement = i;
            if(missingElement!=Integer.MIN_VALUE && repeatingElement!=Integer.MIN_VALUE)
                break;
        }

        return new ArrayList<>(Arrays.asList(missingElement,repeatingElement));
    }

    public static ArrayList<Integer>mathsApproach(int[] arr)
    {
        int Sn = ((arr.length)*(arr.length + 1) / 2);
        int S=0;
        for(int element:arr)
            S+=element;
        int val1 = S - Sn;//val1 = x - y

        int S2 = 0;
        int S2N = (((arr.length)*(arr.length+1)*(2*arr.length + 1)) / 6);

        for(int element:arr)
            S2 += (element * element);

        int val2 = S2 - S2N;//S2 = 39  S2N = 55,S2N - S2 = 16,
        val2 = (val2/val1);
        //val2 = x + y

        int repeatingElement = ((val1 + val2) / 2);
        int missingElement = repeatingElement - val1;

        return new ArrayList<>(Arrays.asList(missingElement,repeatingElement));

    }

    public static void main(String[] args)
    {
        //S=15, Sn = 13, -2 = Sn - S
        //x-y = -2; y->Missing, x->Repeating
        //x2 - y2 =
        int[] arr = {3,2,3,4,1};
        //ArrayList Format:missingElement, repeatingElement
        ArrayList<Integer>al1 = MissingAndRepeatingElement.bruteForceApproach(arr);
        System.out.println(al1);

        ArrayList<Integer>al2 = MissingAndRepeatingElement.hashingApproach(arr);
        System.out.println(al2);

        ArrayList<Integer>al3 = MissingAndRepeatingElement.mathsApproach(arr);
        System.out.println(al3);


    }
}
