package com.example.awesomefat.tsp;

import java.util.LinkedList;

/**
 * Created by awesomefat on 5/3/16.
 */
public class Node
{
    private String name;
    private LinkedList<Edge> edges = new LinkedList<Edge>();

    public Node(String name)
    {
        this.name = name;
    }

    public void addEdge(Node destination, int weight)
    {
        this.edges.add(new Edge(destination, weight));
        //System.out.println("Adding Edge: " + this.name + " -> " + destination.name + "(" + weight + ")");
    }

    public void visit(Node destinationGoal, int runningTotalWeight, LinkedList<Node> prevNodes)
    {
        for(Edge e : this.edges)
        {
            if(e.getDestination() == destinationGoal)
            {
                //we have arrived, print out the path and total weight
                System.out.println("Arrived at Destination -> Total Weight: " + (runningTotalWeight + e.getWeight()));
                //run through our list and show the places we visit in the right order.
            }
            else
            {
                LinkedList<Node> prevNodesCopy = new LinkedList<Node>();
                prevNodesCopy.addAll(prevNodes);
                prevNodesCopy.add(this);
                e.getDestination().visit(destinationGoal, runningTotalWeight + e.getWeight(), prevNodesCopy);
            }
        }
    }

    public String getName()
    {
        return name;
    }

    public LinkedList<Edge> getEdges()
    {
        return edges;
    }
}
