package baekjoon.silver;

import java.util.*;

public class P1904_S3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        System.out.println(fib(N));
    }

    static int fib(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++) dp[i]=(dp[i-1] + dp[i-2])%15746;
        return dp[n];
    }
}
