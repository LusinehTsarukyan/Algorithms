package week4;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void merge() throws FileNotFoundException {
//        Graph graph = new Graph("C:/Users/Lyulik/Desktop/coursera/testGraph.txt");
//        Edge edge = graph.edges.get(2);
//        graph.merge(edge.u, edge.v);
//        int minCut = graph.vertices.size() - 1; //Call an arbitrary vertex s, let t range over all other n-1 vertices, and return the best of the s-t min cuts founds.
//            int crossingEdges = graph.edges.size();
//            if (crossingEdges < minCut){
//                minCut = crossingEdges;
//            }
//        assertEquals(2, minCut);


//        Graph graph1 = new Graph("C:/Users/Lyulik/Desktop/coursera/kargerMinCut1.txt");
//        Vertex u = new Vertex(0);
//        Vertex v = new Vertex(0);
//        for (int i = 0; i < graph1.vertices.size(); ++i) {
//            if (graph1.vertices.get(i).label == 2) {
//                u = graph1.vertices.get(i);
//            } else if (graph1.vertices.get(i).label == 4) {
//                v = graph1.vertices.get(i);
//            }
//        }
//        graph1.merge(u, v);
//        for (int i = 0; i < graph1.vertices.size(); ++i) {
//            if (graph1.vertices.get(i).label == 1) {
//                u = graph1.vertices.get(i);
//            } else if (graph1.vertices.get(i).label == 3) {
//                v = graph1.vertices.get(i);
//            }
//        }
//        graph1.merge(u, v);
//        for (int i = 0; i < graph1.vertices.size(); ++i) {
//            if (graph1.vertices.get(i).label == 6) {
//                u = graph1.vertices.get(i);
//            } else if (graph1.vertices.get(i).label == 7) {
//                v = graph1.vertices.get(i);
//            }
//        }
//        graph1.merge(u, v);
    }
}