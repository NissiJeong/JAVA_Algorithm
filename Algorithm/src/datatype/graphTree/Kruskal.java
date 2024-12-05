package datatype.graphTree;

import java.util.ArrayList;
import java.util.Arrays;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class Kruskal {
    int V, E;//V:정점의 개수, E: 간선의 개수
    Edge[] edges;

    Kruskal(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
    }

    int find(int[] parent, int i) {
        if(parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if(xset != yset)
            parent[xset] = yset;
    }

    void MST() {
        Arrays.sort(edges); //가중치가 작은 순부터 정렬

        // index 가 정점, 값이 부모
        int[] parent = new int[V];
        // 처음에는 모든 정점의 부모가 없어서 -1 로 채움
        Arrays.fill(parent, -1);

        // 간선을 그래프에 추가해줄 때 mst(list) 에 추가
        // 추 후 해당 간선으로만 계산하면 최소가 나온다.
        ArrayList<Edge> mst = new ArrayList<>();

        //weight 가 작은 순으로 가져와서
        for(Edge edge : edges) {
            int x = find(parent, edge.src); //내가 속한 정점의 가장 최상위 부모
            int y = find(parent, edge.dest);

            // 같지 않으면 사이클 없으면
            if(x != y) {
                mst.add(edge);
                union(parent, x, y);
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        for(Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        Kruskal graph = new Kruskal(V, E);

        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        graph.MST();
    }
}
