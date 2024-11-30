package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 테스트케이스 t
 *  2. 수첩 1 정수의 개수 n
 *  3. 정수들 n개
 *  4. 수첩 2 정수의 개수 m
 *  5. 정수들 m개
 * 출력:
 *  1. 있으면1, 없으면 0
 * 로직:
 *  1. 이진탐색
 */
public class P2776_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int k=0; k<t; k++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) {
                int key = Integer.parseInt(st.nextToken());

                int result = binarySearch(key, 0, arr.length-1, arr);

                bw.write(result+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int key, int lo, int hi, int[] arr) {
        int mid;

        if(lo<=hi) {
            mid = lo + ((hi-lo)/2);
            if(key == arr[mid]) return 1;
            else if(key < arr[mid]) return binarySearch(key, lo, mid-1, arr);
            else return binarySearch(key, mid+1, hi, arr);
        }

        return 0;
    }
}
