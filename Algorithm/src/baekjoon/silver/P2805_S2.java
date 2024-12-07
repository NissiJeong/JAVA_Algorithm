package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. 나무의 수 N, 나무의 길이 M
    2. N개 나무의 높이
출력:
    1. 절단기에 설정할 수 있는 높이의 최댓값.
문제해석:
    1. 나무의 개수 N 에서 M 길이 만큼의 나무를 가져온다.
    2. 높이 H 인 절단기 위로 잘리는 나무만 가져온다.
    3. 최대 H의 높이는?
로직
    1. 1..N arr[i] = treeH;
    2. Arrays.sort(arr);
    3. int maxH = max treeH / 2;
    4. sum tree H < M -> maxH = maxH + (max treeH - maxH)/2
    5. binarySearch(maxH);
문제:
    1. 위 로직에서는 최소 M 보다 큰 값을 구할 수 없다.
    2. 작은 값부터 순서대로 올라가면서 나무의 길이를 구하면 시간 초과가 날 것임.
새로운 로직:
    1. ch 를 넘겨서 이 값보다 작아진 index 를 찾아서
    2. 그 위의 값들을 sum 한다.
    3. sum 이 M 보다 작으면(-> 낮은 인덱스에 저장) ch 를 줄여서 새로운 ch 보다 작은 index 를 찾아서
    4. 그 위의 값들을 sum 한다.
    5. sum 이 M 보다 크거나 같으면(-> 높은 인덱스에 저장) ch 를 높여서 새로운 ch 보다 작은 index 를 찾아서
    6. 그 위의 값들을 sum 한다.
    7. bigIdx - lowIdx <= 1 까지 위 행동 반복
문제
    1. 시간초과가 났다.
문제
    1....
로직
    1. 이분탐색의 중간 값을 가져오면 된다?
    2. 중간값으로 잘라서 sum 하면
    3. 그 sum 값이 M보다 작으면 중간을 내리고
    4. 그 sum 값이 M보다 크면 중간을 올리고
    5. 인덱스로 이분탐색이 아니라 나무 길이로 이분탐색 하는 것임.
*/

public class P2805_S2 {
    static int N,M;
    static int[] arr;
    static int maxTree = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int treeH = Integer.parseInt(st.nextToken());
            arr[i] = treeH;
            maxTree = Math.max(maxTree, arr[i]);
        }

        Arrays.sort(arr);

        int cutHeight = binarySearch();

        System.out.println(cutHeight);
    }

    static int binarySearch() {
        int low = 0;
        int hi = maxTree;
        int rtnH = 0;

        while(low <= hi) {
            int mid = low + (hi -low)/2;

            // 자른 나무들의 합이 M 보다 작다면 중간을 내리고
            if(sumArr(mid) < M) {
                hi = mid-1;
            }
            // 자른 나무들의 합이 M 보다 크다면 중간을 올리고
            else {
                rtnH = mid;
                low = mid+1;
            }
        }

        return rtnH;
    }

    static long sumArr(int mid) {
        long sum = 0;
        for(int tree : arr) {
            if(tree > mid) sum += tree-mid;
        }

        return sum;
    }
}