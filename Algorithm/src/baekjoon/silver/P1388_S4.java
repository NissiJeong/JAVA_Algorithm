package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 세로크기 N, 가로크기 M
 *  2. N개 줄에 M 개의 문자(- |, 0<=N,M<=50)
 * 출력:
 *  1. 문제의 정답
 * 로직:
 *  1. arr[N][M]
 *  2. if arr[n][m] == '-' -> if arr[n][m-1] == '-' --> no count
 *                         -> if arr[n][m-1] == '|' --> count++
 *  3. if arr[n][m] == '|' -> if arr[n-1][m] == '-' --> count++
 */
public class P1388_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        String[][] arr = new String[N][M];
        for(int i=0; i<N; i++) arr[i] = br.readLine().split("");

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if("-".equals(arr[i][j]) && (j == M-1 || "|".equals(arr[i][j+1]))) count++;
                if("|".equals(arr[i][j]) && (i == N-1 || "-".equals(arr[i+1][j]))) count++;
            }
        }

        System.out.println(count);
    }
}
