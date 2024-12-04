package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 정수 n(n<=50)
 *  2. A에 있는 n개의 수(0<=a<=100)
 *  3. B에 있는 n개의 수(0<=a<=100)
 * 출력:
 *  1. S의 최솟값
 * 로직:
 *  1. A는 재배열 필요 -> priorityQueue 오름차순
 *  2. B는 재배열 금지 -> priorityQueue 내림차순
 *  3. sum += aPq.poll() * bPq.poll()
 */
public class P1026_S4_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> aPq = new PriorityQueue<>();
        PriorityQueue<Long> bPq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) aPq.add(Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) bPq.add(Long.parseLong(st.nextToken()));

        long sum = 0;
        while(!aPq.isEmpty()) {
            sum += aPq.poll() * bPq.poll();
        }

        System.out.println(sum);
    }
}
