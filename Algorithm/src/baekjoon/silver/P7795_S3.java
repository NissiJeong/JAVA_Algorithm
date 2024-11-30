package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 테스트케이스 t
 *  2. A의 수 n, B의 수 m
 *  3. n개의 자연수(A)
 *  4. m개의 자연수(B)
 * 출력:
 *  1. 각 테이스마다 A>B 인 쌍의 개수
 * 로직:
 *  1. 이진탐색의 개념을 이용한 lowBound 를 사용하면 될 듯.
 */
public class P7795_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] nArr = new int[n];
            int[] mArr = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++) nArr[k] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++) mArr[k] = Integer.parseInt(st.nextToken());

            Arrays.sort(mArr);
            int count = 0;
            for(int k=0; k<n; k++) {
                int l = lowBound(nArr[k], mArr);
                count += l;
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int lowBound(int key, int[] arr) {
        int low = 0;
        int hi = arr.length;

        while(low < hi) {
            int mid = low + (hi-low)/2;

            if(key <= arr[mid]) hi = mid;
            else low = mid+1;
        }

        return low;
    }
}
