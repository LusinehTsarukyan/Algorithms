package week4;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void merge() throws FileNotFoundException {
        Graph graph1 = new Graph("C:/Users/Lyulik/Desktop/coursera/kargerMinCut1.txt");
        Vertex u = new Vertex(0);
        Vertex v = new Vertex(0);
        Iterator iter = graph1.vertices.keySet().iterator();
        while (iter.hasNext()) {
            Vertex temp = graph1.vertices.get(iter.next());
            if (temp.label == 2){
                u = temp;
            }else if(temp.label == 4){
                v = temp;
            }
        }
        int res = graph1.merge(u, v, graph1.vertices.size());
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