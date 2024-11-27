package baekjoon.silver;

import java.io.*;

/**
 * 문제분석
 * - 주어진 실수들의 연속된 곱 중 가장 큰 값을 구한다
 * <p></p>
 * 문제풀이
 * - 입력된 n 개만큼 실수가 입력된다
 * - n 만큼 반복하면서 저장할 새로운 자료구조를 만든다.
 *   현재 값 * 이전 값 >= max -> dp[i] = 현재 값 * 이전 값 => 연속된 값의 곱을 저장하다가 현재 값이 크면 현재 값을 dp[i] 에 저장
 *   max >= dp[i] -> max = dp[i]
 * - 이중 배열을 만들고, 곱한 값들을
 */
public class P2670_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] dp = new double[n+1];
        double max = 0;
        for (int i = 1; i <= n; i++) {
            double d = Double.parseDouble(br.readLine());
            dp[i] = Math.max(d, dp[i-1] * d);
            max = Math.max(max, dp[i]);
        }
        System.out.print(Math.round(max*1000.0)/1000.0);
    }
}
