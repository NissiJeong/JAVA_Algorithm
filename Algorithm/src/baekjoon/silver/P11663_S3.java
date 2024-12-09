package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. 점의 개수 N, 선의 개수 M(1<=N,M<=100000)
    2. N개의 점의 좌표
    3. M줄동안 선분 시작점, 끝점
출력:
    1. 입력으로 주어진 선분마다 선분 위에 입력으로 주어진 점이 몇개?
문제:
    1. 각 선분 위에 입력으로 주어진 점이 몇개?
로직:
    1. 주어진 점들을 arr에 담고 sort
    2. lowerBound 와 upperBound 를 찾고 u-l 하면 될 듯
*/

public class P11663_S3 {
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int uIdx = upperBound(y, arr);
            int lIdx = lowerBound(x, arr);

            System.out.println("uIdx = " + uIdx);
            System.out.println("lIdx = " + lIdx);

            bw.write((uIdx-lIdx)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int lowerBound(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while(lo<hi) {
            int mid = (lo+hi) / 2;

            if(key <= arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static int upperBound(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while(lo<hi) {
            int mid = (lo + hi) / 2;

            if(key < arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }
}
