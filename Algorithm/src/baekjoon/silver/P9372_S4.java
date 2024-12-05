package baekjoon.silver;

import java.io.IOException;

import java.io.*;
import java.util.*;

/**
 * 입력
 *  1. 테스트 케이스의 수 T
 *  2. 국가의 수 N(2<=N<=1000), 비행기 종류 M(1<=M<=10000)
 *  3. M개의 줄 a,b(1<=a,b<=n, a!=b)
 *  4. 비행기는 항상 연결 그래프를 이룬다.
 * 출력
 *  1. 상근이가 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수
 * 로직
 *  1. 가장 적은 종류의 비행기
 *  2. 비행기를 타면서 2..N 까지 나올 수 있는 최소 개수
 *  3. 비행기는 다 이어져 있다..... N-1
 */
public class P9372_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            for(int i=0; i<M; i++) br.readLine();

            bw.write((N-1)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
