package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P24479_S2_R{
    static int N,M,R;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        check = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(adjList.get(i));
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(check[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int s) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{s, 1});

        while(!stack.isEmpty()) {
            int[] arr = stack.pop();
            int c = arr[0];
            int count = arr[1];

            if(!visited[c]) {
                visited[c] = true;
                check[c] = count;

                for(int i=adjList.get(c).size()-1; i>=0; i--) {
                    int n = adjList.get(c).get(i);
                    if(!visited[n]) stack.push(new int[]{n, count+1});
                }
            }
        }
    }
}