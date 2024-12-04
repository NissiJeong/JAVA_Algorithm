package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. N(1<=N<=1000000)
 *  2. n개의 수(10^9<=X<=10^9)
 * 출력:
 *  1. 연산된 n개의 수
 * 로직:
 *  1. n개의 수를 받는다.
 *  2. 압축된 수는 본인보다 작은 서로다른 수가 몇개인지 count
 *      상세로직:
 *          1. arr1, set1 생성
 *          2. arr1, set1 add(int)
 *          2-1. set1 -> list & list 정렬
 *          3. arr1 순회 -> list 로우 바운드 메소드 생성
 *          4. list index 반환
 */
public class P18870_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        Set<Integer> set1 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr1[i] = k;
            set1.add(k);
        }

        List<Integer> list1 = new ArrayList<>(set1);
        Collections.sort(list1);

        for(int i=0; i<n; i++) {
            int idx = lowBound(arr1[i], list1);
            bw.write(idx+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int lowBound(int key, List<Integer> list1) {
        int low = 0;
        int hi = list1.size();

        while(low<hi) {
            int mid = low + (hi-low)/2;

            if(key <= list1.get(mid)) hi = mid;
            else low = mid+1;
        }

        return low;
    }
}
