package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. N(1<=N<=500000, 홀수)
    2. N개의 줄 정수(|x| < 4000)
출력:
    1. 첫째 줄에는 산술평균(소수점 이하 첫째 자리에서 반올림)
    2. 중앙값
    3. 최빈값(여러개인 경우 두번째로 작은 값)
    4. 범위
문제:
    1. 산술평균: N개의 합을 N으로 나눈 값
    2. 중앙값: 오름차순 중 중앙에 위치한 값
    3. 최빈값: 가장 많이 나타나는 값
    4. 범위: 최댓값과 최솟값의 차이
로직
    1. arr 로 받은 후 오름차순
    2. 받으면서 합 구하고 평균 구하기
    3. arr의 가운데 값 중앙값
    4. map 에 담고 count+1? maxCount 갱신하면서
    5. arr 최댓값, 최솟값 구하고 -
*/

public class P2108_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> count = new HashMap<>();

        double sum = 0;
        int maxCnt = 0;
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            arr[i] = n;
            count.put(n, count.getOrDefault(n, 0)+1);
            maxCnt = Math.max(maxCnt, count.getOrDefault(n, 0));
        }

        Arrays.sort(arr);
        double avg = sum / ((double) N);
        int mid = arr[arr.length/2];
        int range = arr[arr.length-1] - arr[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int key : count.keySet()) {
            if(count.get(key) == maxCnt) {
                pq.add(key);
            }
        }
        int many = 0;
        if(pq.size() == 1) many = pq.poll();
        else {
            pq.poll();
            many = pq.poll();
        }


        System.out.println(Math.round(avg));
        System.out.println(mid);
        System.out.println(many);
        System.out.println(range);
    }
}