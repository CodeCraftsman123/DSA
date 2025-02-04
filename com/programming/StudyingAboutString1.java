package com.programming;
import java.util.Arrays;
import java.util.ArrayList;

public class StudyingAboutString1
{
    public static void main(String[] args)
    {
        char[] array = {'A','B','C'};
        System.out.println(Arrays.toString(array));

        ArrayList<Integer>al = new ArrayList<>();
        al.add(3);
        System.out.println(al);

        ArrayList<Character>characterList = new ArrayList<>();
        characterList.add('P');
        characterList.add('R');
        characterList.add('A');
        System.out.println(characterList);
    }
}
