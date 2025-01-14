package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1654_S2_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int max = 0;
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        long hi = max;
        long lo = 1;
        long result = 0;
        while(lo<=hi) {
            long mid = lo + (hi-lo)/2;
            long count = calcCount(arr, mid);
            if(count >= N) {
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }

        System.out.println(result);
    }

    static long calcCount(int[] arr, long mid) {
        long sum = 0;
        for(int i : arr) {
            sum += i/mid;
        }
        return sum;
    }
}
