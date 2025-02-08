package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1932_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n+1];
        int[][] dp = new int[n][n+1];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=1; k<i+2; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1] = arr[0][1];
        for(int i=1; i<n; i++) {
            for(int k=1; k<=i+1; k++) {
                dp[i][k] = Math.max(dp[i-1][k-1], dp[i-1][k])+arr[i][k];
            }
        }

        int max = -1;
        for(int i=1; i<=n; i++) {
            max = Math.max(dp[n-1][i], max);
        }

        System.out.println(max);
    }
}
