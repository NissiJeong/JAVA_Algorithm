package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 테스트케이스 T
 *  2. 지원자의 숫자 n(1<=n<=100000)
 *  3. n개의 줄 -> 서류 rank, 면접 rank (두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.)
 * 출력:
 *  1. 테스트 별 최대 인원수
 * 로직:
 *  1. 서류순위로 정렬 후, 면접 순위에 따라 최대 최소 구하기
 *  2. arr[서류 순위] = 면접 순위 -> 자동 서류 순위로 정렬
 *  3. arr 순회 -> 배열 각 i 의 값들(면접) 이 이전 i의 값보다 작으면(합격) count++
 */
public class P1946_S1_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int minInterviewRank = arr[1];
            int count = 1;
            for(int i=2; i<n; i++) {
                if(minInterviewRank > arr[i]) {
                    minInterviewRank = arr[i];
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
