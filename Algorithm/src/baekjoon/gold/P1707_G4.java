package baekjoon.gold;

import java.util.*;
import java.io.*;

public class P1707_G4 {
    static List<List<Integer>> adjList;
    static int[] colors;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            adjList = new ArrayList<>();
            colors = new int[V+1];
            isBipartite = true;

            for(int i=0; i<=V; i++) adjList.add(new ArrayList<>());

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            for(int i=1; i<=V; i++) {
                if(colors[i] == 0) bfs(i);
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1; //첫 정점을 1로 표시

        while(!queue.isEmpty() && isBipartite) {
            int current = queue.poll();

            for(int next : adjList.get(current)) {
                if(colors[next] == 0) {// 방문한 곳이 아닐 때
                    colors[next] = -colors[current]; //반대 값으로 색칠
                    queue.add(next);
                } else if(colors[next] == colors[current]) {
                    isBipartite = false; //같은 값이 발견되면 이분 그래프가 아님
                    return;
                }
            }
        }
    }
}
