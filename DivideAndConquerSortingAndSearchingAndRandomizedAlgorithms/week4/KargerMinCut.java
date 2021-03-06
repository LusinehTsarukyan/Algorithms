package DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.week4;

import java.io.FileNotFoundException;

public class KargerMinCut {
    /**
     * The file contains the adjacency list representation of a simple undirected graph.
     * There are 200 vertices labeled 1 to 200. The first column in the file represents the vertex label,
     * and the particular row (other entries except the first column) tells all the vertices that the vertex is
     * adjacent to. So for example, the 6^{th}6
     * th
     * row looks like : "6	155	56	52	120	......". This just means that the vertex with label 6 is adjacent
     * to (i.e., shares an edge with) the vertices with labels 155,56,52,120,......,etc
     * <p>
     * Your task is to code up and run the randomized contraction algorithm for the min cut problem and use it on the
     * above graph to compute the min cut. (HINT: Note that you'll have to figure out an implementation of edge contractions.
     * Initially, you might want to do this naively, creating a new graph from the old every time there's an
     * edge contraction. But you should also think about more efficient implementations.) (WARNING:
     * As per the video lectures, please make sure to run the algorithm many times with different random seeds,
     * and remember the smallest cut that you ever find.) Write your numeric answer in the space provided. So e.g.,
     * if your answer is 5,
     * just type 5 in the space provided.
     */

    public static Integer minCut(Graph graph) throws FileNotFoundException {
        int minCut = (int) Math.pow(2, graph.vertices.size() - 1) - 1;
        for (int i = 0; i <= (int) (Math.pow(graph.vertices.size(), 2) * Math.log(graph.vertices.size())); i++) {
            Graph g = graph.deepClone();
            if(i % 100 == 0) {
                System.out.println("                   calling randomContract " + i + "th time");
            }
            randomContract(g);
            int crossingEdges = g.edges.size();
            if (crossingEdges < minCut) {
                minCut = crossingEdges;
                System.out.println(minCut);
            }
        }
        return minCut;
    }

    public static void randomContract(Graph graph) {
        while (graph.vertices.size() > 2) {
            Edge randomEdge = graph.pickRandomEdge();
            graph.merge(randomEdge.u, randomEdge.v);

            //remove self loops already in merge function
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph("C:/Users/Lyulik/Desktop/coursera/kargerMinCut.txt");
        System.out.println("Counting the minimum cut of the graph.");
        System.out.println("min cut == " + minCut(graph));
    }
}
