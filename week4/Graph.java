package week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Graph {
    ArrayList<Vertex> vertices;
    ArrayList<Edge> edges;

    Graph(String path) throws FileNotFoundException {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();

        Scanner in = new Scanner(new File(path));
        while (in.hasNextLine()) {
            Scanner line = new Scanner(in.nextLine());
            int label = line.nextInt();
            Vertex v = new Vertex(label);
            while (line.hasNext()) { //adding adjacent to 'v' vertices.
                int adjToLabel = line.nextInt();
                Vertex adjV = new Vertex(adjToLabel);
                if (v.label < adjV.label) { // not the same edge
                    v.adjacentTo.add(adjV);
                }
            }
            vertices.add(v);
        }

        for (int i = 0; i < vertices.size(); ++i) {
            for (int j = 0; j < vertices.get(i).adjacentTo.size(); ++j) {
                Edge edge = new Edge(vertices.get(i), vertices.get(i).adjacentTo.get(j));
                edges.add(edge);
            }
        }

    }

    public Edge pickRandomEdge() {
        Random random = new Random();
        int r = random.nextInt(this.edges.size());
        return edges.get(r);
    }

    public void merge(Vertex u, Vertex v) {
        Vertex newVertex = new Vertex(this.vertices.size() + 1);
        this.vertices.add(newVertex);

        for (int i = 0; i < u.adjacentTo.size(); ++i) {
                newVertex.adjacentTo.add(u.adjacentTo.get(i));
        }
        for (int j = 0; j < v.adjacentTo.size(); ++j) {
                newVertex.adjacentTo.add(v.adjacentTo.get(j));
        }

        //find all u and v and replace it with newVertex
        for (int i = 0; i < vertices.size(); ++i) {
            for (int j = 0; j < vertices.get(i).adjacentTo.size(); ++j) {
                if (vertices.get(i).adjacentTo.get(j).label == u.label
                        || vertices.get(i).adjacentTo.get(j).label == v.label) {
                    vertices.get(i).adjacentTo.remove(vertices.get(i).adjacentTo.get(j));
                    vertices.get(i).adjacentTo.add(newVertex);
                }
            }
        }

        //removing self loops
        for (int i = 0; i < vertices.size(); ++i) {
            for (int j = 0; j < vertices.get(i).adjacentTo.size(); ++j) {
               if(vertices.get(i).label == vertices.get(i).adjacentTo.get(j).label){
                   vertices.get(i).adjacentTo.remove(vertices.get(i).adjacentTo.get(j));
               }
            }
        }

        //edges check
        for (int i = 0; i < edges.size(); ++i) {
            if ((edges.get(i).u.label == u.label && edges.get(i).v.label == v.label)
                    || (edges.get(i).v.label == u.label && edges.get(i).u.label == v.label)) {
                edges.remove(edges.get(i));
            }
            if (edges.get(i).u.label == u.label) {
                edges.get(i).u = newVertex;
            } else if (edges.get(i).v.label == u.label) {
                edges.get(i).v = newVertex;
            } else if (edges.get(i).u.label == v.label) {
                edges.get(i).u = newVertex;
            } else if (edges.get(i).v.label == v.label) {
                edges.get(i).v = newVertex;
            }
        }

        this.vertices.remove(u);
        this.vertices.remove(v);
    }
}
