package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P2667_S1 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

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
                    int hCount = dfs(i,j);
                    pq.add(hCount);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }

    static int dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y});
        int count = 0;

        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cx = cur[0];
            int cy = cur[1];

            if(!visited[cx][cy]) {
                count++;
                visited[cx][cy] = true;

                for(int i=0; i<4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny] == 1) {
                        stack.push(new int[]{nx,ny});
                    }
                }
            }
        }

        return count;
    }
}