package baekjoon.silver;

/*
입력:
    1. 강의의 수 N(1<=N<=100000), M(1<=M<=N)
    2. 강의의 길이가 강의 순서대로 분 단위(자연수, <=10000)
출력:
    1. 가능한 블루레이 크기중 최소 값 출력
문제:
    1. N개의 강의를 M개의 블루레이에 녹화
    2. 강의 순서가 바뀌면 안됨, M 개의 블루레이는 모두 같은 크기
    3. 블루레이의 크기 중 최소를 구하는 프로그램
로직:
    1. 이분 탐색으로 블루레이의 크기를 결정한다.
    2. 다 더한 값을 최대로 해서 몇 개의 블루레이가 나오는지 보고
    3. 그 값이 M 개인지?
    4. 최소 블루레이 크기를 가져와야 함
*/

import java.io.*;
import java.util.*;

public class P2343_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int lo = 0;
        int hi = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lo = Math.max(arr[i], lo);
            hi += arr[i];
        }

        int result = 0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;

            int count = calcCount(arr, mid);

            if(count <= M) {
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }

        System.out.println(result);
    }

    static int calcCount(int[] arr, int key) {
        int count = 1;
        int sum = 0;
        for(int k : arr) {
            sum += k;
            if(sum > key) {
                count++;
                sum = k;
            }
        }
        return count;
    }
}
