package baekjoon.bronze;

import java.io.*;

/**
 * 문제 분석
 * - 0층의 i호에는 i명이 산다.
 * - a층의 b호에는 (a-1)층의 1호부터 b호 까지의 합만큼 살아야 한다.
 * - 이 문제는 이전 데이터를 저장하는 새로운 자료구조를 만들어서 저장하는 방식(메모제이션)을 사용해서 풀면 될 것 같다.
 *
 * 문제 풀이
 * - 입력: int t(test case), int k(층), int n(호)
 * - 이중 배열 int[k+1][n+1] 을 만들어서 집마다의 사람들 수를 저장한다.
 * - k층의 n호에는 k층의 n-1호의 사람 + k-1 층의 n호 사람을 다 더하면 된다.
 */
public class P2775_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(printPerson(k,n));
        }
    }

    public static int printPerson(int k, int n) {
        int[][] perArr = new int[k+1][n+1];
        //0층 초기화
        for(int i=1; i<=n; i++) {
            perArr[0][i] = i;
        }

        for(int i=1; i<=k; i++) {
            for(int j=1; j<=n; j++) {
                perArr[i][j] = perArr[i-1][j] + perArr[i][j-1];
            }
        }

        return perArr[k][n];
    }
}
