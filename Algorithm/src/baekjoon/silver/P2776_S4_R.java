package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P2776_S4_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int N = Integer.parseInt(br.readLine());
            int[] nArr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) nArr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(nArr);

            StringBuilder sb = new StringBuilder();
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                int k = Integer.parseInt(st.nextToken());
                int check = binarySearch(k, nArr);
                sb.append(check).append("\n");
            }

            System.out.println(sb);
        }
    }

    static int binarySearch(int k, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;

            if(arr[mid] == k) {
                return 1;
            } else if(arr[mid] < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return 0;
    }
}