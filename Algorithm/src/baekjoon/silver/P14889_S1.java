package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P14889_S1 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        backTrack(1, 0);

        System.out.println(min);
    }

    static void backTrack(int idx, int count) {
        if(count == N/2) {
            int fSum = 0;
            int sSum = 0;
            for(int i=1; i<=N; i++) {
                for(int j=i+1; j<=N; j++) {
                    if(visited[i] && visited[j]) fSum += arr[i][j] + arr[j][i];
                    if(!visited[i] && !visited[j]) sSum += arr[i][j] + arr[j][i];
                }
            }
            min = Math.min(min, Math.abs(fSum-sSum));
            return;
        }

        for(int i=idx; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTrack(i+1, count+1);
                visited[i] = false;
            }
        }
    }
}