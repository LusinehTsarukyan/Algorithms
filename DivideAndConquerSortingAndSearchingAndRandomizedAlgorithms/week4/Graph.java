package DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.week4;

import java.io.*;
import java.util.*;

/**
 * using HashMap as a vertices container, because many operations of adding and removing.
 * HashSet does't have get() method, so HashMap is better for this algorithm.
 * Also using Iterators(not foreach as a loop, because HashMap doesn't let us
 * remove an element in proper way without iterators.
 */
public class Graph implements Cloneable, Serializable {
    HashMap<Integer, Vertex> vertices;
    ArrayList<Edge> edges;
    String path;
    Integer maxSize;

    Graph() {
        vertices = new HashMap<>();
        edges = new ArrayList<>();
    }


    public Graph deepClone() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (Graph) ois.readObject();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    Graph(String path) throws FileNotFoundException {
        this.path = path;
        vertices = new HashMap<>();
        edges = new ArrayList<>();

        Scanner in = new Scanner(new File(path));
        while (in.hasNextLine()) {
            Scanner line = new Scanner(in.nextLine());
            int label = line.nextInt();
            Vertex v = new Vertex(label);
            vertices.put(label, v);
        }

        Scanner in1 = new Scanner(new File(path));
        while (in1.hasNextLine()) {
            Scanner line = new Scanner(in1.nextLine());
            int label = line.nextInt();
            while (line.hasNext()) { //adding adjacent to 'v' vertices.
                int adjToLabel = line.nextInt();
                if (label < adjToLabel) {
                    vertices.get(label).adjacentTo.put(adjToLabel, vertices.get(adjToLabel));
                }
            }
        }

        for (Map.Entry<Integer, Vertex> entry : vertices.entrySet()) {
            Vertex u = entry.getValue();
            for (Map.Entry<Integer, Vertex> entry1 : u.adjacentTo.entrySet()) {
                Vertex v = entry1.getValue();
                Vertex uLableV = vertices.get(u.label);
                Edge edge = new Edge(uLableV, uLableV.adjacentTo.get(v.label));
                edges.add(edge);
            }
        }
        maxSize = this.vertices.size();
    }


    public Edge pickRandomEdge() {
        Random random = new Random();
        int r = random.nextInt(this.edges.size());
        return edges.get(r);
    }

    public void merge(Vertex u, Vertex v) {
        this.maxSize = maxSize + 1;
        Vertex newVertex = new Vertex(maxSize);
        this.vertices.put(newVertex.label, newVertex);

        for (Map.Entry<Integer, Vertex> entry : u.adjacentTo.entrySet()) {
            newVertex.adjacentTo.put(entry.getValue().label, entry.getValue());
        }
        for (Map.Entry<Integer, Vertex> entry : v.adjacentTo.entrySet()) {
            newVertex.adjacentTo.put(entry.getValue().label, entry.getValue());
        }

        this.vertices.remove(u.label);
        this.vertices.remove(v.label);

        //find all u and v and replace it with newVertex
        for (Map.Entry<Integer, Vertex> entry : vertices.entrySet()) {
            Iterator<Map.Entry<Integer, Vertex>> adjToIter = entry.getValue().adjacentTo.entrySet().iterator();
            int oldVertexCount = 0;
            while (adjToIter.hasNext()) {
                Map.Entry<Integer, Vertex> entry1 = adjToIter.next();
                if (entry1.getKey().equals(u.label) || entry1.getKey().equals(v.label)) {
                    adjToIter.remove();
                    oldVertexCount++;
                }
            }
            while (oldVertexCount > 0) {
                entry.getValue().adjacentTo.put(newVertex.label, newVertex);
                oldVertexCount--;
            }
        }

        //removing self loops
        for (Map.Entry<Integer, Vertex> entry : vertices.entrySet()) {
            entry.getValue().adjacentTo.entrySet().removeIf(entry1 -> entry.getValue().label == entry1.getValue().label);
        }

        //edges check
        int edgeSize = 0;
        while (edgeSize < edges.size()) {
            int uLable = edges.get(edgeSize).u.label;
            int vLable = edges.get(edgeSize).v.label;
            if ((uLable == u.label && vLable == v.label) || (vLable == u.label && uLable == v.label)) {
                edges.remove(edges.get(edgeSize));
            } else {
                edgeSize++;
            }
        }

        for (int i = 0; i < edges.size(); ++i) {

            Edge tempEdge = edges.get(i);
            if (tempEdge.u.label == u.label) {
                tempEdge.u = newVertex;
            } else if (tempEdge.v.label == u.label) {
                tempEdge.v = newVertex;
            } else if (tempEdge.u.label == v.label) {
                tempEdge.u = newVertex;
            } else if (tempEdge.v.label == v.label) {
                tempEdge.v = newVertex;
            }
        }
    }
}
