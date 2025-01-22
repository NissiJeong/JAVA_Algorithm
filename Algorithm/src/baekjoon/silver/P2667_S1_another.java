package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P2667_S1_another {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Map<Integer, Integer> orders = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N+1][N+1];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    count++;
                    dfs(i,j,count);
                }
            }
        }

        for(int key : orders.keySet()) {
            pq.add(orders.get(key));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }

    static void dfs(int x, int y, int count) {
        if(visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        orders.put(count, orders.getOrDefault(count, 0)+1);

        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny, count);
            }
        }
    }
}
