package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P18111_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int land = Integer.parseInt(st.nextToken());
                pq1.add(land);
                pq2.add(land);
            }
        }

        int time = 0;
        while(pq1.peek() != pq2.peek()) {
            if(B>0) {
                int land = pq1.poll() + 1;
                pq1.add(land);
                time += 1;
            }
            else {
                int land = pq2.poll() - 1;
                pq2.add(land);
                B++;
                time += 2;
            }
        }

        System.out.println(time + " " +pq2.peek());
    }
}