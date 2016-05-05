package com.example.awesomefat.tsp;

import java.util.LinkedList;

/**
 * Created by awesomefat on 5/3/16.
 */
public class Core
{
    static LinkedList<Node> nodes = new LinkedList<Node>();

    static Node getNodeByName(String name)
    {
        for(Node n : nodes)
        {
            if(n.getName().equals(name))
            {
                return n;
            }
        }
        return null;
    }

    static void findPaths(String startNode, String endNode)
    {
        Node start = getNodeByName(startNode);
        Node end = getNodeByName(endNode);
        start.visit(end, 0, new LinkedList<Node>());

    }
}
