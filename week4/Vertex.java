package week4;

import java.util.ArrayList;

public class Vertex {
    int label;
    ArrayList<Vertex> adjacentTo;

    public Vertex(int label){
        this.label = label;
        adjacentTo = new ArrayList<>();
    }
}
