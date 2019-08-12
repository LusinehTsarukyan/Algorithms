package week4;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class KargerMinCutTest {

    @Test
    void minCut() throws FileNotFoundException {
        Graph graph = new Graph("C:/Users/Lyulik/Desktop/coursera/testGraph.txt"); //kargerMinCut1.txt");
        int res = KargerMinCut.minCut(graph);
        assertEquals(2, res);

        Graph graph1 = new Graph("C:/Users/Lyulik/Desktop/coursera/kargerMinCut1.txt");
        int res1 = KargerMinCut.minCut(graph1);
        assertEquals(2, res1);
    }
}