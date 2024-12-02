package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. n(1<=n<=50)
 *  2. A에 있는 n개의 수(0<=A<=100)
 *  3. B에 있는 수(0<=B<=100)
 * 출력:
 *  1. S의 최솟값
 * 로직:
 *  1. B의 값은 pq에 넣고 가장 큰 값이 위로 오도록 배치
 *  2. A의 값은 배열에 넣고 가장 작은 값이 앞으로 오도록 정렬
 *  3. 각 행을 곱하기.
 */
public class P1026_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] aArr = new int[n];
        PriorityQueue<Integer> bPq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) aArr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) bPq.add(Integer.parseInt(st.nextToken()));

        Arrays.sort(aArr);

        int sum = 0;
        for(int i=0; i<n; i++) sum += (aArr[i]*bPq.poll());

        System.out.println(sum);
    }
}
