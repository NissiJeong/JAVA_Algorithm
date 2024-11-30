package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 카드의 개수 n (1<=n<=500000)
 *  2. n개 카드에 적혀있는 정수 (-10000000 <= a <= 10000000)
 *  3. m (1<=m<=500000)
 *  4. m개 카드에 적혀있는 정수 (-10000000 <= a <= 10000000)
 * 출력:
 *  1. m개의 수에 대해서 각 수가 상근이가 갖고 있으면 1 아니면 0
 * 로직1:
 *
 */
public class P10815_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nArr = new int[n];
        for(int i=0; i<n; i++) nArr[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] mArr = new int[m];
        for(int i=0; i<m; i++) mArr[i] = Integer.parseInt(st.nextToken());

        //nArr 정렬, mArr 정렬
        Arrays.sort(nArr);
        //Arrays.sort(mArr);

        //m 1개씩 돌면서 n에 있는지 체크 -> 이걸 이진탐색으로
        for (int j : mArr) {
            int check = -1;
            check = searchBinary(j, 0, nArr.length - 1, nArr);
            bw.write((check != -1 ? 1 : 0) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int searchBinary(int target, int left, int right, int[] arr) {
        int mid;

        if(left <= right) {
            mid = (left+right) / 2;

            if(target == arr[mid]) return mid;
            else if(target < arr[mid]) return searchBinary(target, left, mid-1, arr);
            else return searchBinary(target, mid+1, right, arr);
        }

        return -1;
    }
}
