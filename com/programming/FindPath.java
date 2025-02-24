package com.programming;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class FindPath
{
    public static void main(String[] args)
    {
        HashMap<String,String>hashmap = new HashMap<>();
        hashmap.put("Chennai","Bengaluru");
        hashmap.put("Mumbai","Delhi");
        hashmap.put("Goa","Chennai");
        hashmap.put("Delhi","Goa");

        HashSet<String>keys = new HashSet<>();
        HashSet<String>values = new HashSet<>();
        ArrayList<String>path = new ArrayList<>();
        String startingPoint = "";

        for(String element:hashmap.keySet())
        {
            keys.add(element);
            values.add(hashmap.get(element));
        }

        for(String element:keys)
        {
            if(!values.contains(element))
                startingPoint = element;
        }

        while(path.size()!=(values.size()+1))
        {
            path.add(startingPoint);
            startingPoint = hashmap.get(startingPoint);
        }

        System.out.println("Path:"+path);

    }
}
