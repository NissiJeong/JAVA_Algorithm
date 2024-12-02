package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 테스트 케이스 T
 *  2. 지원자의 수 N(1<=N<=100000)
 *  3. 서류, 면접
 * 출력:
 *  1. 선발 최대 인원 수
 * 로직:
 *  1. 순위가 다른 지원자보다 둘다 낮을 경우 탈락
 *  2. int[2][n] arr 에 담아 놓고
 *  3. 돌면서 앞에게 뒤처졌을 때 뒤에거 비교
 *  4. 뒤에거도 뒤쳐지면 continue; 그대로 돌면 +1
 * -------> 시간 초과
 */
public class P1946_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] score = new int[N+1];
            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                score[x] = y;
            }

            int count = 1;
            int yNum = score[1];
            for(int i=2;i<=N;i++){
                if(yNum > score[i]){
                    yNum = score[i];
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
