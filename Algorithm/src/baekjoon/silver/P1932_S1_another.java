package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1932_S1_another {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0][0];

        for(int i=1; i<n; i++) {
            for(int j=i; j>=0; j--) {
                if(j==0) dp[j] = dp[j] + arr[i][j];
                else dp[j] = Math.max(dp[j], dp[j-1]) + arr[i][j];
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
