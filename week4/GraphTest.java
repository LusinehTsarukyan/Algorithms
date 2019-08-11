package week4;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void merge() throws FileNotFoundException {
        Graph graph = new Graph("C:/Users/Lyulik/Desktop/coursera/testGraph.txt");
        Edge edge = graph.edges.get(2);
        graph.merge(edge.u, edge.v);
    }
}