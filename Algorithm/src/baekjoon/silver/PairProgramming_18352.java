package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력
1. 도시개수 N, 도로개수 M, 출발 X

단방향, 최단거리 K
오름차순

bfs 사용.
정렬
 */
public class PairProgramming_18352 {
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
        }

        bfs(start, K);
    }

    static void bfs(int start, int K) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<int[]> queue = new LinkedList<>();
        int depth = 0;
        List<Integer> list = new ArrayList<>();

        queue.add(new int[]{start, depth});
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int cx = cur[0];

            if(!visited[cx]) {
                visited[cx] = true;
                int cd = cur[1];

                if(cd == K) list.add(cx);

                for(int i=0; i<adjList[cx].size(); i++) {
                    int next = adjList[cx].get(i);
                    if(!visited[next]) {
                        int nd = cd+1;
                        queue.add(new int[]{next, nd});
                    }
                }
            }
        }

        if(list.isEmpty()) bw.write(-1+"");
        else {
            Collections.sort(list);
            for(int x : list) {
                bw.write(x+"\n");
            }
        }

        bw.flush();
    }
}
