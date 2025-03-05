package com.programming;
import java.util.HashMap;

public class ComparingHashSet
{
    public static void main(String[] args) {
        HashMap<String,Integer>hashmap1 = new HashMap<>();
        HashMap<String,Integer>hashmap2 = new HashMap<>();

        hashmap1.put("A",1);
        hashmap1.put("B",2);
        hashmap1.put("C",3);

        hashmap2.put("C",3);
        hashmap2.put("A",1);
        hashmap2.put("B",2);

        if(hashmap1.equals(hashmap2))
            System.out.println("Same");

    }
}
