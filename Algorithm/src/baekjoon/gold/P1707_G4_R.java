package baekjoon.gold;

import java.io.*;
import java.util.*;

public class P1707_G4_R {
    static List<List<Integer>> adjList;
    static int[] visited;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(K-- >0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            adjList = new ArrayList<>();
            visited = new int[V+1];
            isBipartite = true;
            for(int i=0; i<=V; i++) adjList.add(new ArrayList<>());

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            for(int i=0; i<V; i++) {
                if(visited[i] == 0) {
                    bfs(i);
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 1;
        queue.add(start);

        while(!queue.isEmpty() && isBipartite) {
            int cur = queue.poll();

            for(int next : adjList.get(cur)) {
                if(visited[next] == 0) {
                    visited[next] = -visited[cur];
                    queue.add(next);
                } else if(visited[next] == visited[cur]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
