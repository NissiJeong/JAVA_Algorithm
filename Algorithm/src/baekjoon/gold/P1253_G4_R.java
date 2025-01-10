package baekjoon.gold;

/*
입력:
    1. 수의 개수 N(1<=N<=2000)
    2. A가 N개 (|A|<=1000000000)
출력:
    1. 좋은 수의 개수
문제:
    1. N개의 수 중에서 어떤 수가 다른 수 두개의 합으로 나타낼 수 있다면 그 수를 좋다
    2. 좋은 수의 개수 출력
    3. 수의 위치가 다르면 값이 같더라도 다른 수
로직:
    1. 2000번을 2000번씩 반복하는 것은 시간 초과
    2. 다른 알고리즘 필요
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_G4_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int count = 0;
        for(int i=0; i<N; i++) {
            int k = arr[i];
            int left = 0;
            int right = N-1;
            while(left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if(sum < k) {
                    left++;
                }
                else if(sum > k) {
                    right--;
                }
                else {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
