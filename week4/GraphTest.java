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
        int minCut = graph.vertices.size() - 1; //Call an arbitrary vertex s, let t range over all other n-1 vertices, and return the best of the s-t min cuts founds.
        for (int i = 0; i < graph.vertices.size() - 1; i++){
            int crossingEdges = graph.edges.size();
            if (crossingEdges < minCut){
                minCut = crossingEdges;
            }
        }
        assertEquals(2, minCut);
    }
}