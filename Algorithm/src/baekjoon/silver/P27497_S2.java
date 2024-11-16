package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 주어진 숫자 n 만큼 반복
 * - 1이면 문자열 가장 뒤에 append
 * - 2면 문자열 가장 앞에 append
 * - 3이면 가장 나중에 추가된 문자 삭제
 *
 * 문제풀이
 * - n만큼 반복문
 * - StringBuilder 이용하여 1:가장뒤, 2:가장앞, 3:가장 나중에 추가된 문자 삭제
 * - 가장 나중에 추가된 문자 삭제
 *   반복문 돌면서 map 에 인덱스(반목분 i)와 추가된 문자의 위치(앞,뒤)를 같이 저장하고 있다가
 *   3이 나온 경우 i-3count 문자를 삭제
 *
 * - 위의 방법대로 진행하였는데 시간 초과가 난다.
 * - 다른 방법을 찾아야 하는데,
 * - n 만큼 반복문을 실행하긴 해야하고 for 문 안에 map, StringBuilder, List 외의 다른 자료구조 사용 해봐야 할듯.
 * - 문자열 앞으로 추가,삭제 문자열 뒤로 추가,삭제가 필요 => 자료구조 deque 가 적절
 * - deque 원소 앞뒤 삽입,삭제 O(1), 탐색 O(1)
 * - ArrayDeque
 *   양 끝에서의 데이터 삽입/삭제 속도 빠름
 *   Random Access 속조 빠름
 *   LinkedList 기반에 비행 메모리 소비가 적음
 */
public class P27497_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Deque<Character> strDeque = new ArrayDeque<>();
        Deque<Integer> btnDeque = new ArrayDeque<>(); // 한 방향으로 넣고 한방향으로 빼서 문자열 저장시 버튼 번호 저장

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int btn = Integer.parseInt(st.nextToken());
            // 3번 버튼인 경우
            if(btn == 3){
                // 문자열 비어있으면 아래 코드 실행X
                if(strDeque.isEmpty()) continue;
                int type = btnDeque.pollFirst(); // pollFirst 로 버튼 번호 가져와서

                if(type == 1) strDeque.pollLast(); // 1인 경우 뒤 삭제
                else strDeque.pollFirst(); // 2인 경우 앞 삭제
                //3번 다 끝났으면 아래 코드 실행X
                continue;
            }
            char ch = st.nextToken().charAt(0);
            if(btn == 1) strDeque.addLast(ch); // 버튼 1이면 뒤에 추가
            else strDeque.addFirst(ch); // 버튼 2이면 앞에 추가
            btnDeque.addFirst(btn);
        }

        if(strDeque.isEmpty()) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        // while 문 안에서 하나씩 빼서 출력하는 코드로 진행하면 시간초과
        /*
        while(!strDeque.isEmpty()){
            System.out.print(strDeque.pollFirst());
        }
        */
        while(!strDeque.isEmpty()){
            sb.append(strDeque.pollFirst());
        }
        System.out.println(sb);
    }
}
