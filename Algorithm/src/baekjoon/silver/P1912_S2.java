package baekjoon.silver;

import java.util.*;

public class P1912_S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        dp[0] = arr[0];
        int maxSum = dp[0];

        for(int i=1; i<N; i++) {
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);

        sc.close();
    }
}
