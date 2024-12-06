package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1206_S2 {
    static int N,M,V;
    static int[][] graph;
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());

        // 간선 리스트로 인접행렬로
        graph = new int[N + 1][N + 1]; //노드 값과 인덱스를 맞춰서 편하게 하려고
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        // 방문 처리 담을 리스트
        visitedDfs = new boolean[N+1];
        visitedBfs = new boolean[N+1];

        // DFS 재귀
        dfs_재귀(V);
        System.out.println();

        // DFS 스택
        List<Integer> dfs_result = dfs_스택(V);
        for(int node : dfs_result) {
            System.out.print(node+" ");
        }
        System.out.println();

        //BFS
        List<Integer> bfs_result = bfs_큐(V);
        for(int node : bfs_result) {
            System.out.print(node+" ");
        }
        System.out.println();
    }

    static void dfs_재귀(int node) {
        visitedDfs[node] = true;
        System.out.print(node + " ");

        for(int i=1; i<=N; i++) {
            if(graph[node][i] == 1 && !visitedDfs[i]) {
                dfs_재귀(i);
            }
        }
    }

    static List<Integer> dfs_스택(int start) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        stack.push(start);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(!visited[node]) {
                visited[node] = true;
                result.add(node);

                //스택에서는 거꾸로 넣어줘야 한다.
                for(int i = N; i>= 1; i--) {
                    if(graph[node][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }

        return result;
    }

    static List<Integer> bfs_큐(int start) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(start);
        visitedBfs[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(!visitedBfs[node]) {
                result.add(node);

                for(int i = 1; i<=N; i++) {
                    if(graph[node][i] == 1 && !visitedBfs[i]) {
                        queue.add(node);
                        visitedBfs[i] = true;
                    }
                }
            }
        }

        return result;
    }
}