package datatype.graph;

/**
 * 그래프를 인전 행렬(2차원 배열)로 나타냄!!
 * 무방향그래프(대칭)
 * 장점
 *  1. 단순
 *  2.O(1) 시간 복잡도로 간선의 존재 확인 가능
 * 단점
 *  1. O(N^2)의 높은 공간 복잡도를 필요
 *  2. 엣지가 늘어나면 공간을 다시 만들어야 한다. -> 정점의 개수가 변할때 좋지 않음
 */
public class GraphAdjMatrix {
    private int vertices;
    private int[][] adjMatrix;

    // 총 정점의 개수 전달
    public GraphAdjMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // 엣지끼리 간선 추가
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    public void removeEdge(int src, int dest) {
        adjMatrix[src][dest] = 0;
        adjMatrix[dest][src] = 0;
    }

    public boolean isEdge(int src, int dest) {
        return adjMatrix[src][dest] != 0;
    }
}
