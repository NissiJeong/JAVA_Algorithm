package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 분석
 * - 이항계수..! 를 알아보자...
 * - 이항계수란 무엇인가?
 * - 단순하게 풀어보면 nCk 'n choose k' 고정된 n 개의 요소 집합에서 k 개 요소의 (순서 없는) 하위 집합을 선택하는 방법
 * - 예를 들어서 4C2 => {1,2,3,4} 중 {1,2}, {1,3}, {1,4}, {2,3}, {2,4}, {3,4} => 6개
 * - 공식은 4C2 =  n! / k!(n-k)! => 이것을 프로그래밍으로 나타내야 한다.
 * - 이항계수의 성질 중 아래와 같은 성질이 있다.
 * - nCm = (n-1)C(m-1) + (n-1)Cm => 이러한 모습으로 재귀의 성질을 갖고 있다.
 * <p>
 * 문제 풀이
 */
public class P11050_B1 {
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new long[n+1][k+1];

        System.out.println(nCkFunction(n, k));
        //System.out.println(nCkFunction2(n, k));
    }

    // 재귀 함수만 사용할 경우 엄청난 메모리 낭비가 될 수 있다.
    // 이러한 경우 dp 의 개념을 사용하여 메모리 및 수행시간을 줄일 수 있다.
    public static long nCkFunction(int n, int k) {
        if(dp[n][k] != 0) return dp[n][k];

        if(n==k || k==0)
            return dp[n][k] = 1;

        return dp[n][k] = nCkFunction(n-1, k-1) + nCkFunction(n-1, k);
    }

    public static long nCkFunction2(int n, int k) {

        if(n==k || k==0)
            return 1;

        return factorial(n) / (factorial(k)*factorial(n-k));
    }

    public static long factorial(int n) {
        long[] dp = new long[n+1];

        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] * i;
        }

        return dp[n];
    }
}
