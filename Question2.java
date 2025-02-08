/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Ntshangase
 * Ntokozo
 * 4123601
 * CSC212 2022 Practical 4 Term 1
 * Question2.java
 */
public class Question2 
{
    //creating array to store household deliveries attributes
    private HouseholdDeliveries hDArr[] = new HouseholdDeliveries[9];
    //size to keep up with how many objects are in the array
    private int size = 0;
    
    public Question2()
    {
        //try statement for dangerous code
        try
        {
            //scanner to read the file into java
            Scanner scFile = new Scanner(new File("household-deliveries.csv"));
        
            //line to store each line of code
            String line = "";
            //storing attributes of household deliveries from csv file
            String source = "";
            String destination = "";
            int distance = 0;
            
            //while loop to check if file has another line
            while(scFile.hasNext())
            {
                line = scFile.nextLine();
                
                //new scanner to break up content of the csv file using delimiter of ';'
                Scanner scLine = new Scanner(line).useDelimiter(";");
                //storing values from csv file
                source = scLine.next();
                destination = scLine.next();
                distance = scLine.nextInt();
                
                //adding attributes to the new created array
                hDArr[size] = new HouseholdDeliveries(source, destination, distance);
                //increasing size after adding items to the array
                size++;
                
                //another while loop to check if there are more destinations or distances
                while(scLine.hasNext())
                {
                    //storing more attributes into array
                    String nextDestination = scLine.next();
                    int nextDistance = scLine.nextInt();
                    
                    hDArr[size] = new HouseholdDeliveries(source, nextDestination, nextDistance);
                    size++;
                }
                //closing scanner line
                scLine.close();
            }
            //closing scanner file
            scFile.close();
        }
        //catch statement if there is an error with the file
        catch(FileNotFoundException e)
        {
            //displaying error to the user
            System.out.println("File not found - check path");
        }
    }
    
    //method to get the size variable
    public int getSize()
    {
        return size;
    }
    
    //creating values for bellman ford algorithm
    private int totalDistance[];
    private int numOfVertices = size;
    public static final int MAX_VALUE = 99;
    
    //method to implement the bellman ford algorithm
    public void BellmanFordAlgorithm(int sourceNode, int adjacentMatrix[][])
    {
        //making current nodes = to max value
        for (int node = 1; node <= numOfVertices; node++)
        {
            //assigning max value to distance array
            totalDistance[node] = MAX_VALUE;
        }
 
        //giving source node a value of 0 as the starting node
        totalDistance[sourceNode] = 0;
        
        //running for loop untile there are no more vertices
        for (int node = 1; node <= numOfVertices - 1; node++)
        {
            for (int nodeSource = 1; nodeSource <= numOfVertices; nodeSource++)
            {
                for (int nodeDestination = 1; nodeDestination <= numOfVertices; nodeDestination++)
                {
                    //checking if matrix doesnt = max value
                    if (adjacentMatrix[nodeSource][nodeDestination] != MAX_VALUE)
                    {
                        //checking if destination distance is greater than the source + the adjacent nodes
                        if (totalDistance[nodeDestination] > totalDistance[nodeSource] + adjacentMatrix[nodeSource][nodeDestination])
                        {
                            //assigning variable to total distance
                            totalDistance[nodeDestination] = totalDistance[nodeSource] + adjacentMatrix[nodeSource][nodeDestination];
                        }
                    }
                }
            }
        }
        
        //running for loop until there are no more nodes
        for (int nodeSource = 1; nodeSource <= numOfVertices; nodeSource++)
        {
            for (int nodeDestination = 1; nodeDestination <= numOfVertices; nodeDestination++)
            {
                //checking if the graph contains any negative cycles
                if (adjacentMatrix[nodeSource][nodeDestination] != MAX_VALUE)
                {
                    if (totalDistance[nodeDestination] > totalDistance[nodeSource] + adjacentMatrix[nodeSource][nodeDestination])
                    {
                        //displaying error to user
                        System.out.println("Error: This graph contains negative egde cycles - bellman ford algorithm cant handle negative cyckes");
                    }
                }
            }
        }
        
        //running for loop until shortest path is found
        for (int foundVertex = 1; foundVertex <= numOfVertices; foundVertex++)
        {
            System.out.println("The distance of the source node " + sourceNode + " to the vertex " + foundVertex + " is = " + totalDistance[foundVertex]);
        }
    }
    
    //toString method to display are the contents of the array
    @Override
    public String toString() 
    {
        //creating temp value for all array content
        String temp = "";
        
        //running for loop until all contents of the array have been displayed
        for(int i = 0; i<size; i++)
        {
            temp = temp + hDArr[i] + "\n";
        }
        //returning the position i of the array
        return temp;
    }
    
    public static void main(String[] args)
    {
        int numVertices = 0;
        String source = "";
        
        
    }
}
