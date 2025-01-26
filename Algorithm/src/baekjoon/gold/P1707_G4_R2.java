package baekjoon.gold;

import java.io.*;
import java.util.*;

public class P1707_G4_R2 {
    static int V,E;
    static List<List<Integer>> adjList;
    static int[] colors;
    static boolean isGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(K-- >0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            isGraph = true;
            colors = new int[V+1];
            adjList = new ArrayList<>();
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

            sb.append(isGraph ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        colors[s] = 1;

        while(!queue.isEmpty() && isGraph) {
            int c = queue.poll();

            for(int n : adjList.get(c)) {
                if(colors[n] == 0) {
                    colors[n] = -colors[c];
                    queue.add(n);
                }
                else if(colors[n] == colors[c]) {
                    isGraph = false;
                    return;
                }
            }
        }
    }
}
