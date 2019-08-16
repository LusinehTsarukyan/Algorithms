package week4;

import java.io.Serializable;

public class Edge implements Serializable {
    Vertex u;
    Vertex v;

    Edge(Vertex u, Vertex v) {
        this.u = u;
        this.v = v;
    }
}
