package baekjoon.silver;

import java.io.*;

public class P2156_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        if(n>2) {
            dp[2] = Math.max(Math.max(arr[0]+arr[2], arr[1]+arr[2]), dp[1]);
        }
        for(int i=3; i<n; i++) {
            dp[i] = Math.max(Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]), dp[i-1]);
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}