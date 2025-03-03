package baekjoon.silver;

import java.util.*;

/*
1 : 1, 1
2 : 2, 1+1, 2
3 : 4, 1+1+1, 1+2, 2+1, 3
4 : 7, 1+1+1+1, 1+1+2, , 1+2+1, 1+3, 2+1+1, 2+2, 3+1
5 : 13, 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 1+1+3, 1+3+1, 1+2+2
        2+1+1+1, 2+2+1, 2+1+2, 2+3
        3+2, 3+1+1
*/

public class P9095_S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while(t-- >0) {
            int n = sc.nextInt();
            int[] dp = new int[n+1];
            if(n <= 3) {
                if(n<=2) sb.append(n).append("\n");
                else sb.append(4).append("\n");
                continue;
            }

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i=4; i<=n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}