package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 팔린 티켓의 수 n (1<=n<=1000000)
 *  2. 티켓들의 번호 정수 A(1<=A<=2^31-1)
 * 출력:
 *  1. 가장 작은 번호
 * 로직:
 *  1. 입력받은 수를 정렬 후
 *  2. 순서대로 카운트 하면서 비어있는 숫자를 출력
 */
public class P16466_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int k = 1;
        for(int i=1; i<n; i++) {
            if(k!= arr[0]) break;
            if((arr[i] - arr[i-1]) != 1) {
                k = arr[i-1] +1;
                break;
            }
            if(i==(n-1)) k = n+1;
        }

        System.out.println(k);
    }
}
