package datatype.graphTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 그래프를 인전 연결리스트로 나타냄!!
 * 무방향그래프(대칭)
 * 장점
 *
 */
public class GraphAdjList {
    private int vertices;
    private List<List<Integer>> adjList;

    public GraphAdjList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for(int i=0; i<vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void removeEdge(int src, int dest) {
        adjList.get(src).remove(Integer.valueOf(dest));
        adjList.get(dest).remove(Integer.valueOf(src));
    }

    public boolean isEdge(int src, int dest) {
        return adjList.get(src).contains(dest);
    }
}
