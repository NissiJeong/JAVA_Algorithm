package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P24479_S4_recursive {
    static int N,M,R;
    static boolean[] visited;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] order;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        order = new int[N+1];
        for(int i=0; i<=N; i++) adjList.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for(int i=1; i<=N; i++) Collections.sort(adjList.get(i));

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start) {
        if(visited[start]) return;

        visited[start] = true;
        order[start] = count++;

        for(int i=0; i<adjList.get(start).size(); i++) {
            int next = adjList.get(start).get(i);
            if(!visited[next]) dfs(next);
        }
    }
}
