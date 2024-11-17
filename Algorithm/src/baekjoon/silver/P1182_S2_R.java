package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1182_S2_R {
    static int N,S;
    static int[] arr;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        backTrack(0, 0, false);

        System.out.println(count);
    }

    static void backTrack(int idx, int sum,boolean isPlus) {
        if(idx == N) {
            if(sum == S && isPlus) count++;
            return;
        }

        backTrack(idx+1, sum+arr[idx], true);

        backTrack(idx+1, sum, isPlus);
    }
}
