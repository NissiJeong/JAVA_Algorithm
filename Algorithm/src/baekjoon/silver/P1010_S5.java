package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1010_S5 {

    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            dp = new int[m+1][n+1];

            System.out.println(createBridge(m, n));
        }
    }

    public static int createBridge(int m, int n) {

        if(dp[m][n] > 0) return dp[m][n];

        if(n==m || n==0) return dp[m][n] = 1;
        else return dp[m][n] = createBridge(m-1, n-1) + createBridge(m-1, n);
    }
}