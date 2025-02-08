/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question2;

/**
 * Ntshangase
 * Ntokozo
 * 4123601
 * CSC212 2022 Practical 4 Term 1
 * HouseholdDeliveries.java
 */
public class HouseholdDeliveries 
{
    //attributes of household deliveries
    private String source;
    private String destination;
    private int distance;

    //contructor for attributes
    public HouseholdDeliveries(String source, String destination, int distance) 
    {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    //getter methods for attributes
    public String getSource() 
    {
        return source;
    }

    public String getDestination() 
    {
        return destination;
    }

    public int getDistance() 
    {
        return distance;
    }

    //setter methods for attributes
    public void setSource(String source) 
    {
        this.source = source;
    }

    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public void setDistance(int distance) 
    {
        this.distance = distance;
    }
    
    

    //toString method to display all attributes of household deliveries
    @Override
    public String toString() 
    {
        return "HouseholdDeliveries{" + "source=" + source + 
                ", destination=" + destination + 
                ", distance=" + distance + '}';
    }
}
