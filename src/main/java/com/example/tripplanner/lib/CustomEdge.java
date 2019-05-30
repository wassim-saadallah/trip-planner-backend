package com.example.tripplanner.lib;

import org.jgrapht.graph.DefaultEdge;

import java.io.Serializable;

public class CustomEdge extends DefaultEdge implements Serializable {
    @Override
    public String toString() {
        return "{\"source\":" + super.getSource() + ",\"target\":" + super.getTarget() + "}";
    }
}
