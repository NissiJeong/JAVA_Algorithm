package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력: 후보의 수 n, n개의 숫자
 * 출력: 매수해야 하는 최솟값
 * 로직:
 *  1. 5 7 7 인 경우 각각 1씩 가져와야한다.
 *  2. 1..n 반복 -> 입력된 숫자를 map 에 저장 & 최대값을 찾음.
 *  2-1 n==1 return 0;
 *  3. 최대값과 - 1번 득표 만큼 반복
 *  3-1. 최대값으로 1 가져오면서 다른 값들과 비교
 *
 *  로직은 간단한데 어떤 자료구조를 사용해야 할지 알 수 없었다.
 *  이 문제를 통해 우선순위 큐를 공부해야겠다.
 */
public class P1417_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 총 후보 수
        int m = Integer.parseInt(br.readLine()); // 다솜이 득표 수

        int count = 0; // 매수 횟수
        if(n != 1) {
            // 다른 후보의 득표수를 내림차순 하기 위한 우선순위 큐 작성
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=1; i<n; i++)
                priorityQueue.add(Integer.parseInt(br.readLine()));

            // 다른 후보자들의 가장 큰 득표수가 다솜이 표 이상일 때 계속 매수(반복) 진행
            while(priorityQueue.peek() >= m) {
                int peek = priorityQueue.poll(); // 가장 큰 득표수
                peek--;
                m++;
                priorityQueue.add(peek);
                count++;
            }
        }

        System.out.print(count);
    }
}
