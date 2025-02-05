package baekjoon.silver;

import java.util.*;

public class P1904_S3_another {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp=new int[N+1];
        Arrays.fill(dp, -1);

        System.out.println(fib(N));
    }

    static int fib(int n) {
        if(n==1) return 1;
        if(n==2) return 2;

        if(dp[n] != -1) return dp[n];

        return dp[n]=(fib(n-1) + fib(n-2))%15746;
    }
}
