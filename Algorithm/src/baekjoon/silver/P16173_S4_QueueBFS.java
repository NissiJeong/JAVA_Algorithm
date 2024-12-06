package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BFS!!!
 */
public class P16173_S4_QueueBFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(N, arr) ? "HaruHaru" : "Hing");
    }

    public static boolean bfs(int n, int[][] arr) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];

            if(arr[x][y] == -1) return true;

            if(x+arr[x][y] < n && !visited[x+arr[x][y]][y]) {
                visited[x+arr[x][y]][y] = true;
                queue.add(new int[]{x+arr[x][y], y});
            }
            if(y+arr[x][y] < n && !visited[x][y+arr[x][y]]) {
                visited[x][y+arr[x][y]] = true;
                queue.add(new int[]{x, y+arr[x][y]});
            }
        }

        return false;
    }
}
