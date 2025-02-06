package baekjoon.silver;

import java.util.*;

public class P9461_S3 {
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while(T-- >0) {
            int N = sc.nextInt();
            dp = new long[N+1];
            Arrays.fill(dp, -1);
            long pn = dp(N);
            sb.append(pn).append("\n");
        }

        System.out.println(sb);
    }

    static long dp(int n) {
        if(n == 1 || n== 2 || n == 3) return 1;

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        if(dp[n] != -1) return dp[n];

        return dp[n] = dp(n-2)+dp(n-3);
    }
}