package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. n(1<=n<=100000)
 *  2. 정보 n개(유형1, 2)
 * 출력:
 *  1. 최대학생 수 + ' ' + 맨 뒤 대기중 학생 번호
 * 로직:
 *  1. 먼저 도착한 학생 앞쪽 대기
 *  2. queue 선언해서 데이터 입력
 *  3. 1 -> 학생 추가 / 2 -> 맨앞 학생 빼
 *  4. 1..n 반복하면서 위 로직 실행
 *  4-1. queue 개수 최댓값 갱신
 *  4-2. 가장 작은 학생 번호 갱신
 */
public class P26042_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> intQueue = new LinkedList<>();

        int maxCnt = 1;
        int minNum = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type == 1) {
                int stNum = Integer.parseInt(st.nextToken());
                intQueue.addLast(stNum);

                if(maxCnt <= intQueue.size()) {
                    if(intQueue.size() == maxCnt) {
                        if(minNum > stNum) minNum = stNum;
                    } else {
                        maxCnt = intQueue.size();
                        minNum = stNum;
                    }
                }
            }
            else intQueue.pollFirst();
        }

        System.out.println(maxCnt+" "+minNum);
    }
}
