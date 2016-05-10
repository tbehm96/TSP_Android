package com.example.awesomefat.tsp;

import java.util.LinkedList;

public class City
{
    private String cityName;
    private LinkedList<Edge> theEdges;

    public City(String cityName)
    {
        this.cityName = cityName;
        this.theEdges = new LinkedList<Edge>();
    }

    public String getCityName()
    {
        return cityName;
    }

}