package baekjoon.silver;

import java.util.*;

public class P14888_S1 {
    static int N;
    static int[] arr;
    static int[] calcs = new int[4];
    static PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        for(int i=0; i<4; i++) calcs[i] = sc.nextInt();

        backTrack(1, arr[0]);

        System.out.println(pq2.peek());
        System.out.println(pq1.peek());
    }

    static void backTrack(int idx, int value) {
        if(idx == N) {
            pq1.add(value);
            pq2.add(value);
            return;
        }

        int k = arr[idx];
        for(int i=0; i<4; i++) {
            if(calcs[i] > 0) {
                calcs[i]--;
                int temp = 0;
                if(i==0) temp = value+k;
                else if(i==1) temp = value-k;
                else if(i==3) {
                    if(value >= 0) temp = value / k;
                    else temp = (Math.abs(value) / k) * -1;
                }
                else temp = value * k;
                backTrack(idx+1, temp);
                calcs[i]++;
            }
        }
    }
}