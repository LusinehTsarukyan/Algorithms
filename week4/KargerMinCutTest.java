package week4;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static week4.KargerMinCut.randomContract;

class KargerMinCutTest {

    @Test
    void minCut() throws FileNotFoundException {
        Graph graph = new Graph("C:/Users/Lyulik/Desktop/coursera/testGraph.txt"); //kargerMinCut1.txt");
        int res = KargerMinCut.minCut(graph);
        assertEquals(2, res);

        Graph graph1 = new Graph("C:/Users/Lyulik/Desktop/coursera/kargerMinCut1.txt");
        int res1 = KargerMinCut.minCut(graph1);
        assertEquals(2, res1);

        Graph graph2 = new Graph("C:/Users/Lyulik/Desktop/coursera/input_random_10_25.txt");
        int minCut = (int) Math.pow(2, graph2.vertices.size() - 1) - 1;
        for (int i = 0; i < (int) (Math.pow(graph2.vertices.size(), 2) * Math.log(graph2.vertices.size())); i++) {
            Graph g = graph2.deepClone();
            if(i % 100 == 0) {
                System.out.println("                   calling randomContract " + i + "th time");
            }
            int result = g.vertices.size();
            while (g.vertices.size() > 2) {
                Edge randomEdge = g.pickRandomEdge();
                System.out.println("random edge nodes -> (" + randomEdge.u.label + ", " + randomEdge.v.label + ")");
                result = g.merge(randomEdge.u, randomEdge.v, result);

                //remove self loops already in merge function
            }
            int crossingEdges = g.edges.size();
            if (crossingEdges < minCut) {
                minCut = crossingEdges;
                System.out.println(minCut);
            }
        }
        int res2 = KargerMinCut.minCut(graph2);
        assertEquals(6, res2);
    }
}