package baekjoon.silver;

import java.util.*;

public class P14888_S1 {
    static int N;
    static int[] arr;
    static int[] calcs = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        for(int i=0; i<4; i++) calcs[i] = sc.nextInt();

        backTrack(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void backTrack(int idx, int value) {
        if(idx == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
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