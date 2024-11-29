package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 거점지 방문 횟수 n
 *  2. 숫자 a(1<=a<=100)
 *  3. a 개의 숫자(<100000)
 * 출력:
 *  1. a 0: 선물의 가치, 줄 선물이 없다면 -1
 * 로직:
 *  1. 우선순위 큐 선언 pq
 *  2. 거점 방문 시마다 선물 충전 pq.add(선물)
 *  3. a != 0 -> pq.poll() 출력
 */
public class P14235_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a==0) {
                if(pq.isEmpty()) bw.write(-1+"\n");
                else bw.write(pq.poll()+"\n");
            }
            else {
                for(int k=0; k<a; k++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
