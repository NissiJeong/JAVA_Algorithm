package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1260_S2 {
    static int N,M,V;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static List<Integer> dfsOrders;
    static List<Integer> bfsOrders;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        dfsVisited = new boolean[N+1];
        bfsVisited = new boolean[N+1];
        dfsOrders = new ArrayList<>();
        bfsOrders = new ArrayList<>();

        for(int i=0; i<=N; i++) adjList.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for(int i=1; i<=N; i++) Collections.sort(adjList.get(i));

        dfs(V);
        bfs(V);

        StringBuilder sb = new StringBuilder();
        for (int dfsOrder : dfsOrders) sb.append(dfsOrder).append(' ');
        sb.append("\n");
        for (int bfsOrder : bfsOrders) sb.append(bfsOrder).append(' ');

        System.out.println(sb);
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()) {
            int cur = stack.pop();

            if(!dfsVisited[cur]) {
                dfsVisited[cur] = true;
                dfsOrders.add(cur);

                for(int i=adjList.get(cur).size()-1; i>=0; i--) {
                    int next = adjList.get(cur).get(i);
                    if(!dfsVisited[next]) stack.push(next);
                }
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(!bfsVisited[cur]) {
                bfsVisited[cur] = true;
                bfsOrders.add(cur);

                for(int i=0; i<adjList.get(cur).size(); i++) {
                    int next = adjList.get(cur).get(i);
                    if(!bfsVisited[next]) queue.add(next);
                }
            }
        }
    }
}
