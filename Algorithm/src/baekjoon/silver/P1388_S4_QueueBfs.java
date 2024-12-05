package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS!!!
 */
public class P1388_S4_QueueBfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];

        for(int i=0; i<N; i++) arr[i] = br.readLine().toCharArray();

        System.out.println(bfs(N,M,arr));
    }

    public static int bfs(int n, int m, char[][] arr) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j]) {
                    count++;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0], y = poll[1];

                        if(y+1 < m && arr[x][y] == '-' && arr[x][y+1] != '|') {
                            visited[x][y+1] = true;
                            queue.add(new int[]{x, y+1});
                        }
                        if(x+1 < n && arr[x][y] == '|' && arr[x+1][y] != '-') {
                            visited[x+1][y] = true;
                            queue.add(new int[]{x+1, y});
                        }
                    }
                }
            }
        }

        return count;
    }
}
