package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. t
 *  2. 소설 장 수 k (3<=k<=100000)
 *  3. 수록한 파일 크기 K개(<=10000)
 * 출력:
 *  1. 최소 비용
 * 로직:
 *  1. 각 파일의 크기를 두개씩 더해서 그 합을 누적
 *  2. 누적 합이 가장 작은 경우를 출력
 *  3. 어떤 조합으로 sum 을 해야 최소인가?
 */
public class P13975_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- >0) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i=0; i<k; i++) pq.add(Long.parseLong(st.nextToken()));

            long sum = 0L;
            for(int i=0; i<k-1; i++) {
                long num = pq.poll() + pq.poll();
                sum += num;
                pq.add(num);
            }

            sb.append(sum+"\n");
        }

        System.out.println(sb);
    }
}
