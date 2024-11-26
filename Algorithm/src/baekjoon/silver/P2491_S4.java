package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 🗂 문제분석
 * - 주어진 N개의 숫자로 이루어진 수열
 * - 연속되면서 이전보다 이상의 값이거나 연속되면서 이전보다 이하의 값이 가장 길게 이어진 길이 찾기
 * - 0 <= N <= 100000 → 데이터의 개수가 많아서 효율적인 자료구조 사용
 * - 반복을 하며 이전의 값과 비교, 수열의 개수 증가 필요 → 반복된 연산이 있을 듯 → DP로 문제 풀이
 * - 현재 연산의 값을 새로운 자료구조에 저장하고 이전 단계로 돌아가지 않는 방법을 찾아야 한다.
 * <p>
 * 💻 문제 풀이
 * - 정수 N 을 입력받는다.
 * - N 만큼 반복하면서 현재 단계의 연산 값을 저장할 자료구조를 생각한다.
 * 해당 문제에서는 새로운 자료구조에 입력값, 이상의 수열 카운트 값, 이하의 수열 카운트 값을 저장해야 한다.
 * → 이중배열에 저장하면 될 듯, int[][] dp 사용
 * - 반복문을 돌면서 이전값과 비교해야 하니 첫번째 값은 먼저 초기화
 * - 반복문을 돌면서 dp[0]에 현재 값 저장, 이상의 수열 카운트는 dp[1]에 저장, dp[2]에 이하의 수열 카운트 저장
 * - 반복문을 돌면서 마지막에 그 중 가장 큰 값을 갖고 있는다. 반복문을 돌며 점점 해당 값이 커질 수도 있고 비교가 가능하다.
 */
public class P2491_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정수 n 값 입력
        int n = Integer.parseInt(br.readLine());
        // 수열 값 입력
        st = new StringTokenizer(br.readLine());

        // 현재의 연산 값 저장(메모제이션)하기 위한 새로운 배열
        int[][] dp = new int[3][n+1];
        // 이전값과 비교하기 위해 첫번째 값 초기화
        dp[0][1] = Integer.parseInt(st.nextToken());
        // 이상의 수열 카운트 1로 초기화
        dp[1][1] = 1;
        // 이하의 수열 카운트 1로 초기화
        dp[2][1] = 1;
        int max = 1;
        for(int i=2; i<=n; i++) {
            // i 번째 값 저장
            dp[0][i] = Integer.parseInt(st.nextToken());
            // 이전 값보다 현재 값이 크거나 같으면 이상의 수열 현재 카운트 = 이전 카운트 + 1
            if(dp[0][i] >= dp[0][i-1]) {
                dp[1][i] = dp[1][i-1] + 1;
            }
            // 이전 값보다 현재 값이 작으면 이상의 수열 현재 카운트 = 1
            else {
                dp[1][i] = 1;
            }
            // 이전 값보다 현재 값이 작거나 같으면 이하의 수열 현재 카운트 = 이전 카운트 + 1
            if(dp[0][i] <= dp[0][i-1]) {
                dp[2][i] = dp[2][i-1] + 1;
            }
            // 이전 값보다 현재 값이 크면 이하의 수열 현재 카운트 = 1
            else {
                dp[2][i] = 1;
            }
            // 반복문을 돌며 최대값 계산
            max = Math.max(max, Math.max(dp[1][i], dp[2][i]));
        }

        System.out.print(max);
    }
}
