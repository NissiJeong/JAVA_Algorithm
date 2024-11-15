package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 분석
 * - 주어진 두 숫자 문자열을 역순하여 비교하는 프로그램을 만들어야 한다.
 *
 * 문제 풀이
 * - 문자열 두개를 입력 받음
 * - 각각의 문자열을 역순
 * - 역순된 문자열을 int로 바꾸고 비교
 *
 */
public class P2908_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder num1Str = new StringBuilder(st.nextToken());
        StringBuilder num2Str = new StringBuilder(st.nextToken());

        int num1 = Integer.parseInt(num1Str.reverse().toString());
        int num2 = Integer.parseInt(num2Str.reverse().toString());

        int max = Math.max(num1, num2);
        System.out.println(max);
    }
}
