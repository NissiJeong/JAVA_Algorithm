package baekjoon.silver;

import java.util.*;

public class P10844_S1_R {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        final int MOD = 1_000_000_000;

        // DP 배열 선언
        long[][] dp = new long[N + 1][10];

        // 초기값 설정 (길이가 1일 때)
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        // DP 점화식 적용
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;  // 0일 때는 1에서만 올 수 있음
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % MOD;  // 9일 때는 8에서만 올 수 있음
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;  // 1~8일 때
                }
            }
        }

        // 결과 계산
        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        System.out.println(result);
        sc.close();
    }
}
