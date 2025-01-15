package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P24444_S2_R {
    static int N,M,R;
    static boolean[] visited;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] orders;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        orders = new int[N+1];
        for(int i=0; i<=N; i++) adjList.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for(int i=1; i<=N; i++) Collections.sort(adjList.get(i));

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) sb.append(orders[i]).append("\n");

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(!visited[cur]) {
                visited[cur] = true;
                orders[cur] = count++;

                for(int next : adjList.get(cur)) if(!visited[next]) queue.add(next);
            }
        }
    }
}
