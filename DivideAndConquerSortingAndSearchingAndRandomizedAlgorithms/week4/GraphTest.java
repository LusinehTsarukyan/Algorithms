package DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.week4;


import org.junit.Test;

import java.io.FileNotFoundException;


class GraphTest {

    @Test
    void merge() throws FileNotFoundException {
        Graph graph1 = new Graph("C:/Users/Lyulik/Desktop/coursera/kargerMinCut1.txt");
//        Vertex u = new Vertex(0);
//        Vertex v = new Vertex(0);
//        Iterator iter = graph1.vertices.keySet().iterator();
//        while (iter.hasNext()) {
//            Vertex temp = graph1.vertices.get(iter.next());
//            if (temp.label == 2){
//                u = temp;
//            }else if(temp.label == 4){
//                v = temp;
//            }
//        }
//        int res = graph1.merge(u, v, graph1.vertices.size());

        Graph graph5 = new Graph("C:/Users/Lyulik/Desktop/coursera/input_random_2_6.txt");
        Vertex u1 = graph5.vertices.get(3);
        Vertex v1 = graph5.vertices.get(4);

        graph5.merge(u1, v1);

        Vertex u2 = graph5.vertices.get(2);
        Vertex v2 = graph5.vertices.get(7);

        graph5.merge(u2, v2);

        Vertex u3 = graph5.vertices.get(1);
        Vertex v3 = graph5.vertices.get(8);

        graph5.merge(u3, v3);
//        for (Vertex key : graph1.vertices) {
//            if (key.label == 1) {
//                u = key;
//            } else if (key.label == 3) {
//                v = key;
//            }
//        }
//        res = graph1.merge(u, v, res);
//        for (Vertex key : graph1.vertices) {
//            if (key.label == 6) {
//                u = key;
//            } else if (key.label == 7) {
//                v = key;
//            }
//        }
//        graph1.merge(u, v, res);
    }
}