/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Ntshangase
 * Ntokozo
 * 4123601
 * CSC212 2022 Practical 4 Term 1
 * Question1.java
 */
public class Question1 
{
    //creating array to store airline network attributes
    private AirlineNetwork aNArr[] = new AirlineNetwork[11];
    //size to keep up with how many objects are in the array
    private int size = 0;
    
    public Question1()
    {
        //try statement for dangerous code
        try
        {
            //scanner to read the file into java
            Scanner scFile = new Scanner(new File("airline-network.csv"));
        
            //line to store each line of code
            String line = "";
            //storing attributes of household deliveries from csv file
            String source = "";
            String destination = "";
            int time = 0;
            
            //while loop to check if file has another line
            while(scFile.hasNext())
            {
                line = scFile.nextLine();
                
                //new scanner to break up content of the csv file using delimiter of ';'
                Scanner scLine = new Scanner(line).useDelimiter(";");
                //storing values from csv file
                source = scLine.next();
                destination = scLine.next();
                time = scLine.nextInt();
                
                //adding attributes to the new created array
                aNArr[size] = new AirlineNetwork(source, destination, time);
                //increasing size after adding items to the array
                size++;
                
                //another while loop to check if there are more destinations or distances
                while(scLine.hasNext())
                {
                    //storing more attributes into array
                    String nextDestination = scLine.next();
                    int nextTime = scLine.nextInt();
                    
                    aNArr[size] = new AirlineNetwork(source, nextDestination, nextTime);
                    size++;
                }
                //closing line
                scLine.close();
            }
            //closing file
            scFile.close();
        }
        //catch statement if there is an error with the file
        catch(FileNotFoundException e)
        {
            //displaying error to the user
            System.out.println("File not found - check path");
        }
    }
    
    //method to find and return closest node
    public static int findCloseNode(int[] time, boolean[] settled)
    {
        int closeNode = -1;
        
        //for loop will run until all nodes are checked
        for(int i = 0; i<time.length; i++)
        {
            //checking which node is the closest or shortest
            if(settled[i] == false && (closeNode == -1 || time[i] < time[closeNode]))
            {
                //storing the closest node in created variable
                closeNode = i;
            }
        }
        //returning closest node
        return closeNode;
    }
    
    //implementation of dijkstra algorithm
    private static void DijkstraAlgorithm(int[][] adjacentMatrix)
    {
        //adding matrix length to matrix lentgh variable
        int adjMatrixLength = adjacentMatrix.length;
        boolean settled[] = new boolean[adjMatrixLength];
        int time[] = new int[adjMatrixLength];
        
        time[0] = 0;
        
        //for loop to run as long as the num variable in adjmatrixlength
        for(int i = 0; i < adjMatrixLength; i++)
        {
            //using method findclosenode to check which is the closest node
            int nearestNode = findCloseNode(time, settled);
            
            //inner for loop 
            for(int x = i; x < adjMatrixLength; x++)
            {
                //checking if the nearest node isnt equal to zero and if it is settled
                if(adjacentMatrix[nearestNode][x] != 0 && settled[x])
                {
                    //if statement is true, create new time variable and assign new variables to it
                    int newTimeVar = time[nearestNode] + adjacentMatrix[nearestNode][x];
                    
                    //checking if new time variable is smaller than the old variable
                    if(newTimeVar < time[x])
                    {
                        time[x] = newTimeVar;
                    }
                }
            }
        }
    }
    
    //toString method to display are the contents of the array
    @Override
    public String toString() 
    {
        //creating temp value for the array
        String temp = "";
        
        //displaying all content of array 
        for(int i = 0; i<size; i++)
        {
            temp = temp + aNArr[i] + "\n";
        }
        //returning position i in the array
        return temp;
    }
    
    public static void main(String[] args)
    {
        //int graph[][] = new int[][];
    }
}
