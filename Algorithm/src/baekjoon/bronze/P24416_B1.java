package baekjoon.bronze;

import java.io.*;

/**
 * 문제분석
 * - 재귀와 dp 함수의 실행동작을 파악하는 문제
 * - 재귀, dp 함수를 구현한 후 실행 횟수를 구한다.
 *
 * 문제풀이
 * - 입력: int n
 * - 피보나치 재귀 함수 구현, dp 함수 구현
 * - 전역 변수로 선언된 count 를 재귀 함수, dp 함수에서 count 실행
 *
 */
public class P24416_B1 {

    static int recCount = 0;
    static int dpCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        recFibonacci(n);
        dpFibonacci(n);

        System.out.println(recCount + " " + dpCount);
    }

    public static int recFibonacci(int n){
        if(n==1 || n==2) {
            recCount++;
            return 1;
        }
        else return recFibonacci(n-1) + recFibonacci(n-2);
    }

    public static int dpFibonacci(int n){
        int[] dpArr = new int[n+1];

        dpArr[1] = 1;
        dpArr[2] = 1;

        for(int i=3; i<=n; i++){
            dpCount++;
            dpArr[i] = dpArr[i-1] + dpArr[i-2];
        }

        return dpArr[n];
    }
}
