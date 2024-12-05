package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS!!
 */
public class P6186_S5_QueueBfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        System.out.println(queueBfs(N, M, arr));
    }

    public static int queueBfs(int n, int m, char[][] arr) {
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<int[]> queue = new LinkedList<>();

        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == '#' && !visited[i][j]) {
                    count++;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];

                        for(int k=0; k<4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == '#' && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
