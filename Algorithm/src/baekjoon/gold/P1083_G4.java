package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. N(<=50)
 *  2. 각 원소(<=1,000,000)
 *  3. S(<=1,000,000)
 * 출력:
 *  1. 사전순으로 가장 뒷서는 것
 * 로직:
 *  1. 사전순 가장 뒤에 있는 것은 가능한 큰수가 가능한 앞으로 오는 것
 *  2. s 만큼 순회 -> 당장 내 뒤에 있는 값이 나보다 크면 스왑 -> O(n^2) 100만개 이하라 무조건 시관초가 날 듯.
 *  3. 그냥 s 만큼 돌면서 막 바꾼 값을 우선수위큐에 넣으면 자동 정렬 되지 않을까
 *      상세로직:
 *          1. arr[i] = n
 *          2. Arrays.sort(arr) -> X
 *          3. 1..s 순회
 *          3-1.
 */
public class P1083_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        PriorityQueue<String> sPq = new PriorityQueue<>(Collections.reverseOrder());

        int S = Integer.parseInt(br.readLine());
        int count = 0;
        boolean flag = false;
        if(S > N*N) S = N*N;
        for(int i=1; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                String[] newArr = arr.clone();
                swap(j, j+1, newArr);
                System.out.println("String.join(' ',newArr) = " + String.join(" ", newArr));
                sPq.add(String.join(" ",newArr));
                count++;
                if(count == S) {
                    flag = true;
                    break;
                }
            }

            if(flag) break;
        }

        System.out.println(sPq.poll());
    }

    public static String[] swap(int i, int j, String[] arr) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }
}
