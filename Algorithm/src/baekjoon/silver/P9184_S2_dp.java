package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 분석
 * - 기존에 제공된 재귀함수 w는 시간이 매우 오래 걸림
 * - 예시를 들어봐도 반복되는 연산이 많음
 * - 반복되는 연산을 줄인다 -> 동정 프로그래밍 메모제이션
 *
 * 문제 풀이
 * - w 함수 내에 재귀함수 호출 시 새로운 배열 dp 에 저장(메모제이션)
 * - 기존에 연산된 값이 있으면 해당 값 반환
 * - 기존 w 함수 내에 있던 조건문은 그대로 사용
 */
public class P9184_S2_dp {

    // 메모제이션을 위한 새로운 자료구조
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 세 정수를 계속 입력받으며, -1 -1 -1이 입력되면 종료
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
        }

        System.out.print(sb);
        br.close();
    }

    // 메모이제이션 활용한 재귀 함수
    static int w(int a, int b, int c) {
        // 이미 계산되었고 범위 안에 세 숫자가 들어온다면 기존 계산되어 있던 값 반환(메모제이션)
        if (a>0 && b>0 && c>0 && a<=20 && b<=20 && c<=20 && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) return dp[20][20][20] = w(20, 20, 20);

        if (a < b && b < c)
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        else
            return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
