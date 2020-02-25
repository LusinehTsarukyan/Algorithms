package DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.week4;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
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
        int res2 = KargerMinCut.minCut(graph2);
        assertEquals(6, res2);

        Graph graph3 = new Graph("C:/Users/Lyulik/Desktop/coursera/input_random_11_25.txt");
        int res3 = KargerMinCut.minCut(graph3);
        assertEquals(8, res3);

        Graph graph4 = new Graph("C:/Users/Lyulik/Desktop/coursera/input_random_3_6.txt");
        int res4 = KargerMinCut.minCut(graph4);
        assertEquals(3, res4);

        Graph graph5 = new Graph("C:/Users/Lyulik/Desktop/coursera/input_random_2_6.txt");
        int res5 = KargerMinCut.minCut(graph5);
        assertEquals(1, res5);    }
}