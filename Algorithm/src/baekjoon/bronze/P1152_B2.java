package baekjoon.bronze;

import java.io.*;

/**
 * 문제 분석
 * - 입력 받은 문자열의 단어 개수를 구하기
 *
 * 문제 풀이
 * - 공백으로 split
 * - 개수 세기
 *
 */
public class P1152_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().trim().split(" ");
        int count = 0;

        for(String str : strArr){
            if(str != null && !str.isEmpty()) count++;
        }

        System.out.println(count);
    }
}
