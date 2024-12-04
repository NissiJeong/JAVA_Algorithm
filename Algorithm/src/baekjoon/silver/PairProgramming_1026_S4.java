package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1.
 * 로직:
 *  1. 배열 a 오름차순
 *  2. 배열 b 내림차순
 *  3. 반복하면 값 1개씩 곱하기
 */
public class PairProgramming_1026_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) b.add(Integer.parseInt(st.nextToken()));

        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += a.poll() * b.poll();
        }

        bw.write(sum+"");
        bw.flush();
    }
}
