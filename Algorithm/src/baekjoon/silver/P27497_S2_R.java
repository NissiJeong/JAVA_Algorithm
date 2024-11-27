package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 문자열과 누른버튼의 조합으로 최종 문자열을 출력한다.
 * - 주어진 n 은 1000000 까지 있어서 효율적인 자료구조가 필요해보인다.
 * - 문자열은 맨 앞과 맨 뒤로 추가,삭제 될 수 있다.
 * - 버튼을 저장하는 자료구조 또한 필요(한 곳으로 들어가 한 곳으로 나온다)
 * <p></p>
 * 문제풀이
 * - 맨 앞과 맨 뒤로 추가 삭제할 수 있는 deque 를 사용한다.
 * - deque 를 한 방향으로 사용하면 stack 처럼 사용할 수 있다.
 * <p></p>
 * array deque 특징
 * - deque 원소 앞뒤 삽입,삭제 O(1), 탐색 O(1)
 * - ArrayDeque
 *   양 끝에서의 데이터 삽입/삭제 속도 빠름
 *   Random Access 속조 빠름
 *   LinkedList 기반에 비행 메모리 소비가 적음
 */
public class P27497_S2_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Deque<String> strDeque = new ArrayDeque<>();
        Deque<String> btnDeque = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String btn = st.nextToken();

            // 먼저 3번 버튼인 경우
            if("3".equals(btn)) {
                // 문자열이 비어있으면 반복문 재 실행
                if(strDeque.isEmpty()) continue;

                // 문자열이 비어있지 않으면 직전 버튼에 따라서 1인 경우 마지막 문자열 삭제, 2인 경우 첫번째 문자열 삭제
                String prevBtn = btnDeque.pollFirst();
                if(prevBtn.equals("1")) strDeque.pollLast();
                else strDeque.pollFirst();
            }
            // 2,3 번인 경우
            else {
                // 문자 받아오고
                String str = st.nextToken();
                // 버튼 넣어놓고
                btnDeque.addFirst(btn);

                // 1번인 경우 문자열 마지막에 문자 추가
                if(btn.equals("1")) strDeque.addLast(str);
                // 2번인 경우 문자열 맨 앞에 문자 추가
                else strDeque.addFirst(str);
            }
        }

        if(strDeque.isEmpty()) System.out.print(0);

        StringBuilder sb = new StringBuilder();
        while(!strDeque.isEmpty()) {
            sb.append(strDeque.pollFirst());
        }

        System.out.print(sb);
    }
}
