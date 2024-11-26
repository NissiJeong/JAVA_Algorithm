package baekjoon.silver;

import java.io.*;

/**
 * 문제분석
 * - 문제는 피보나치 수열의 합을 구하는 듯
 * <p></p>
 * 문제풀이
 * - 피보나치 dp 로 풀고 합 더하기
 */
public class P13301_S5 {

    public static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n+1];
        fibo(n);

        long sum = 0;
        if(n == 1) sum = 4;
        else if(n==2) sum = 6;
        else sum = 2L *(dp[n]+dp[n-1]) + 2L *(dp[n-1]+dp[n-2]);
        System.out.print(sum);
    }

    public static long fibo(int n) {

        if(n == 1) {
            dp[1] = 1;
            return dp[1];
        }
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
