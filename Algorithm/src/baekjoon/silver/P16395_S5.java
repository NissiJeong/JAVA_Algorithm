package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 문제 분석
 * - 파스칼의 삼각형 -> 이항계수
 * - 이항계수의 성질 -> nCm = (n-1)C(m-1) + (n-1)Cm
 * - 이항계수의 특징 -> nCn = 1, nC0 = 1
 * <p></p>
 * 문제 풀이
 * - n,m 이 주어질 때 이항계수 (n-1)C(k-1) 의 값을 구하라
 * - 이항계수의 속성을 이용하여 재귀 + dp 로 풀이
 */
public class P16395_S5 {

    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        dp = new int[n][m];

        System.out.print(bc(n-1, m-1));
    }

    public static int bc(int n, int m) {
        if(n==m || m==0) return 1;

        if(dp[n][m] > 0) return dp[n][m];
        else return dp[n][m] = bc(n-1, m-1) + bc(n-1, m);
    }
}
