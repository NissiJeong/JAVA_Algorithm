package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 참고)
 * Dynamic Programming(동적 프로그래밍) 이란?
 * 큰 문제를 작은 문제로 나누어 푸는 문제. 이 때, 작은 문제를 어딘가에 메모하여 큰 문제를 풀 때 사용한다.
 *
 * 문제 분석
 * - 피보나치 함수를 2가지 구현 함수의 실행 횟수를 카운트 한다.
 *
 * 풀이 방법
 * - 입력 받은 n의 피보나치 함수를 2가지로 구현한다. 재귀, 동적프로그래밍
 * - 각 메서드를 실행 할 때 전역변수로 선언한 카운트 변수를 +1 한다.
 * - 각각의 카운트 변수를 한 줄로 출력한다.
 */
public class P24416 {

    // 코드 실행 카운트 하는 변수
    static int code1Cnt, code2Cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        // 카운트 변수 초기화
        code1Cnt = 0;
        code2Cnt = 0;

        // 재귀 피보나치 메서드 호출
        fib_recursion(n);
        // dp 피보나치 메서드 호축
        fib_dp(n);

        // 출력
        System.out.println(code1Cnt + " " +code2Cnt);
    }

    // dp 피보나치 함수
    private static int fib_dp(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++){
            code2Cnt++;
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // 재귀 피보나치 함수
    public static int fib_recursion(int n) {
        // n=0 이라 의미가 없고, 1과2 일 때 값은 1
        // fib_recursion(2) or fib_recursion(1) 인 경우에만 카운트 하면 됨.
        if(n == 1 || n == 2) {
            code1Cnt++;
            return 1;
        }
        // 결국 재귀함수 호출을 하면 fib_recursion(2) or fib_recursion(2)의 조합으로 마무리 됨.
        else return fib_recursion(n-1) + fib_recursion(n-2);
    }
}
