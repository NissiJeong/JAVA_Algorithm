package baekjoon.silver;

import java.util.*;

public class P2579_S3_R2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] step = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++) step[i] = sc.nextInt();

        if(N==1) {
            System.out.println(step[1]);
            return;
        }

        dp[1] = step[1];
        dp[2] = step[1] + step[2];

        if(N >= 3) dp[3] = Math.max(step[1], step[2]) + step[3];

        for(int i=4; i<=N; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]+step[i-1])+step[i];
        }

        System.out.println(dp[N]);
    }
}