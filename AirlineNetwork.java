/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


/**
 * Ntshangase
 * Ntokozo
 * 4123601
 * CSC212 2022 Practical 4 Term 1
 * AirlineNetwork.java
 */
public class AirlineNetwork 
{
    //attributes
    private String source;
    private String destination;
    private int time;
    

    //constructor
    public AirlineNetwork(String source, String destination, Integer time) 
    {
        this.source = source;
        this.destination = destination;
        this.time = time;
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

    public Integer getTime() 
    {
        return time;
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

    public void setTime(int time) 
    {
        this.time = time;
    }

    //toString method to display attributes of the AirlineNetwork
    @Override
    public String toString() 
    {
        return "AirlineNetwork{" + "source=" + source + ", destination=" + destination + ", time=" + time + '}';
    }
}
