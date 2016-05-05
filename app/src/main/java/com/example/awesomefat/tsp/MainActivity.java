package com.example.awesomefat.tsp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.json.*;

public class MainActivity extends AppCompatActivity
{
    private EditText graphJSONET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.graphJSONET = (EditText)this.findViewById(R.id.graphJSONET);
    }

    public void generateGraphButtonPressed(View v)
    {
        try
        {
            JSONObject obj = new JSONObject(graphJSONET.getText().toString());
            JSONArray nodes = obj.getJSONArray("nodes");
            JSONArray edges = obj.getJSONArray("edges");
            JSONObject currObj;
            for(int i = 0; i < nodes.length(); i++)
            {
                currObj = nodes.getJSONObject(i);
                Core.nodes.add(new Node(currObj.getString("name")));
            }

            for(int i = 0; i < edges.length(); i++)
            {
                currObj = edges.getJSONObject(i);
                Node destination = Core.getNodeByName(currObj.getString("node2"));
                Node source = Core.getNodeByName(currObj.getString("node1"));
                source.addEdge(destination, currObj.getInt("value"));
                destination.addEdge(source, currObj.getInt("value"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
