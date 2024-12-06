package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 지방의 수 n (3<=n<=10000)
 *  2. n개의 정수 (1<=예산<=100000)
 *  3. 총 예산을 나타내는 정수 m (n<=m<=1000000000)
 * 출력:
 *  1. 배정된 예산들 중 최댓값 정수
 * 로직:
 *  1. 1..n -> sum
 *  2.
 */
public class P2512_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(st.nextToken());
            sum += k;
            arr[i] = k;
        }

        int total = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        if(sum < total) {
            bw.write(arr[arr.length-1]+"\n");
        }
        else {

        }
    }
}
