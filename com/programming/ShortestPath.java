package com.programming;
import java.util.Scanner;

public class ShortestPath
{
    public static double calculateDisplacement(String directions)
    {
        int xCoordinate = 0 , yCoordinate = 0;

        for(int i = 0; i < directions.length() ; i++)
        {
            if(directions.charAt(i) == 'E')
                xCoordinate++;
            else if(directions.charAt(i) == 'W')
                xCoordinate--;
            else if(directions.charAt(i) == 'N')
                yCoordinate++;
            else if(directions.charAt(i) == 'S')
                yCoordinate--;
        }

        return Math.sqrt(Math.pow(xCoordinate,2) + Math.pow(yCoordinate,2));
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String directions = scanner.nextLine();

        double displacement = ShortestPath.calculateDisplacement(directions);

        System.out.println("Displacement:"+displacement);
    }
}
