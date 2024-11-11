package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P14889_S1_R {
    static int N;
    static int[][] arr;
    static boolean[] isStart;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        isStart = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        backTrack(1, 0);
        System.out.println(min);
    }

    static void backTrack(int idx, int count) {
        if(count == N/2) {
            int start = 0;
            int link = 0;
            for(int i=0; i<=N; i++) {
                for(int j=i+1; j<=N; j++) {
                    if(isStart[i] && isStart[j]) start += arr[i][j] + arr[j][i];
                    if(!isStart[i] && !isStart[j]) link += arr[i][j] + arr[j][i];
                }
            }
            min = Math.min(min, Math.abs(start-link));
            return;
        }

        for(int i=idx; i<=N; i++) {
            if(!isStart[i]){
                isStart[i] = true;
                backTrack(i+1,count+1);
                isStart[i] = false;
            }
        }
    }
}