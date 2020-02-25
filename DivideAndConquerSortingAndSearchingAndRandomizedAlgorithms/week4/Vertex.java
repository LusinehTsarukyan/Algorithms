package DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.week4;

import java.io.Serializable;
import java.util.HashMap;

public class Vertex implements Serializable {
    int label;
    //using HashMap, because many operations of adding and removing. HashSet does't have get() method,
    // so HashMap is better for this algorithm
    HashMap<Integer, Vertex> adjacentTo;

    public Vertex(int label){
        this.label = label;
        adjacentTo = new HashMap<>();
    }
}
