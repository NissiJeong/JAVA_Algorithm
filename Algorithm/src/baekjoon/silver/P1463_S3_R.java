package baekjoon.silver;

import java.util.*;

public class P1463_S3_R {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        dp[1] = 0;

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1; //1을 빼는 경우

            if(i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1); //2로 나누는 것과 1뺀 값의 비교하여 최소 값
            }
            if(i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1); //3로 나누는 것과 1뺀 값과, 2로 나눈 값을 비교하여 최소 값
            }
        }

        System.out.println(dp[N]);
    }
}
