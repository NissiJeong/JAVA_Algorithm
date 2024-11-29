package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력
 *  1. 연산의 개수 n
 *  2. 연산의 정보 정수 x(자연수: 배열에 x 추가, 0: 가장 작은 값 출력, 제거, 0<=x<2^31)
 * 출력
 *  1. 0의 횟수만큼 답 출력
 * 로직
 *  1. 우선순위 큐로 구현하면 시간초 안에 들어오지 않을까?
 */
public class P1927_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(pq.isEmpty()) bw.write(0+"\n");
                else bw.write(pq.poll()+"\n");
            }
            else
                pq.add(x);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
