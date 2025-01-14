package baekjoon.silver;

/*
입력:
    1. 랜선의 개수 K, 필요한 랜선의 개수 N (1<=K<=10000, 1<=N<=1000000, K<=N)
    2. K 개의 랜선의 길이(1<=x<=2^31-1)
출력:
    1. 첫째 주에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력
문제:
    1. K 개의 랜선을 잘라서 N 개의 랜선을 만들 수 있는 최대 랜선 길이
    2. 만들 수 없는 경우는 없고, N 개 보다 많이 만드는 것도 N 개를 만드는 것에 포함
로직:
    1. 이분 탐색으로 자르면서 자르는 길이를 높였다가 낮췄다가 하면 될 것 같음
*/

import java.io.*;
import java.util.*;

public class P1654_S2 {
    static int K,N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int max = 0;
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        Arrays.sort(arr);

        long lo = 1;
        long hi = max;
        long result = 0;
        while(lo<=hi) {
            long mid = lo+(hi-lo)/2;
            long count = countLan(arr, mid);
            if(count >= N) {
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }

        System.out.println(result);
    }

    static long countLan(int[] arr, long mid) {
        long sum = 0;
        for (int j : arr) {
            sum += j / mid;
        }
        return sum;
    }
}