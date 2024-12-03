package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 정수 n, k (1<=k<=n<=3*10^5)
 *  2. n개의 정수 (1<=a<-10^8)
 * 출력:
 *  1. 경험치 합의 최댓값
 * 로직:
 *  1. n개의 퀘스트 진행
 *  2. k개의 최대 아케인스톤 활성화 개수
 *  3. 원하는 순으로 퀘스트 진행해서 최대의 경험치를 구한다.
 *  4.
 */
public class P16112_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long sum = 0L;
        for(int i=1; i<n; i++) {
            if(i<k)
                sum += i*arr[i];
            else
                sum += k*arr[i];
        }

        System.out.println(sum);
    }
}
