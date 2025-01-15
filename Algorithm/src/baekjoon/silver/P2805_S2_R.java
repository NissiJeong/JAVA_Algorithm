package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P2805_S2_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long hi = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            hi = Math.max(arr[i], hi);
        }

        long lo = 0;
        long result = 0;
        while(lo<=hi) {
            long mid = lo + (hi-lo)/2;

            long sum = 0;
            for(int i=0; i<N; i++) if(arr[i]>mid) sum += (arr[i]-mid);

            if (sum >= M) {
                result = mid;
                lo = mid + 1;
            } else hi = mid - 1;

        }

        System.out.println(result);
    }
}
