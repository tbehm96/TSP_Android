package com.example.awesomefat.tsp;


import android.widget.EditText;

        import java.util.LinkedList;

public class Graph
{
    private LinkedList<City> theCities;
    private LinkedList<Edge> theEdges;
    public Graph()
    {
        this.theCities = new LinkedList<City>();
        this.theEdges = new LinkedList<Edge>();
    }

    public void addCity(String cityName)
    {
        City city1 = new City(cityName);
        this.theCities.add(city1);
    }

    public void addEdge(String cityName, String city2Name, int distance)
    {
        for(City city: this.theCities)
        {
            if(city.getCityName().equals(Core.city2ET.getText().toString()))
            {
                for(City city2: this.theCities)
                {
                    if(city2.getCityName().equals(Core.city3.getText().toString()))
                    {
                        Edge edge = new Edge(city,city2, Integer.parseInt(Core.distanceET.getText().toString()));
                        this.theEdges.add(edge);
                        return;
                    }

                }
            }

        }
        System.out.println("there is not this City!");
    }


    public LinkedList<City> getTheCities()
    {
        return theCities;
    }

    public LinkedList<Edge> getTheEdges()
    {
        return theEdges;
    }

    public void display()
    {
        System.out.println("cities: ");
        for(City city : this.theCities)
        {
            System.out.println(city.getCityName());
        }
        System.out.println("edge distance: ");
        for(Edge edge : this.theEdges)
        {
            System.out.println("City 1: " + edge.getCity1().getCityName());
            System.out.println("Is: " + edge.getDistance());
            System.out.println("From City 2: " + edge.getCity2().getCityName());
        }
    }
}