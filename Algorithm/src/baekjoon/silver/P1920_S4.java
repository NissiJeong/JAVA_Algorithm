package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. n(1<=n<=100000)
 *  2. n개의 정수
 *  3. m(1<=m<=100000)
 *  4. m개의 정수 -2^31 <= <= 2^31
 * 출력
 *  1. m개의 정수들이 a 안에 존재하는지 존재하면 1, 존재하지 않으면 0
 * 로직
 *  1. 이진탐색으로 하는데
 *  2. mid 구하는걸 신경써야 할듯.
 */
public class P1920_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

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

        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int key, int lo, int hi, int[] arr) {
        int mid;

        while(lo <= hi) {
            mid = lo+((hi-lo)/2);
            if(key == arr[mid]) return 1;
            else if(key < arr[mid]) hi = mid-1;
            else lo = mid+1;
        }

        return 0;
    }
}
