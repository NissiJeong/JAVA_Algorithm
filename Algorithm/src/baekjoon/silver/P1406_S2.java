package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력: 문자열(<=100000), 다음줄 명령어 개수 m, m개의 명령어
 * 출력: 명령어 끝난 후 만들어진 문자열
 * 로직
 *  1. 문자열 -> linkedList
 *  2. 0..n 순회하며 명령어 입력
 *  3. 명령어 'L': 커서 왼쪽으로 한칸(인덱스 -1), 'D': 커서 오른쪽으로 이동
 *          'B': 커서 왼쪽 문자 삭제, 'P $': $ 문자 커서 왼쪽에 추가
 *  4. 명령어에 따라 분기 처리
 *
 * 위의 로직대로 실행했지만 시간 초과가 됐음.
 * 다른 자료구조를 사용해야 할 듯
 *
 * likedList 의 remove(index) 시간 복잡도는 O(n) 이다.
 * 해당 인덱스를 찾아야 하기 때문에 이전 노드와 이후 노드를 연결시켜 주는 부분에서 이점이 있을 수 있지만
 * 이렇게 시간이 촉박한 문제에서는 O(n) 을 그대로 가져가기에는 문제가 있다.
 *
 * 그래서 결국 방법을 찾지 못하였고, 다른 방법을 찾아서 공부하였다.
 */
public class P1406_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String inputString = br.readLine();
        int commandCnt = Integer.parseInt(br.readLine());

        Stack<String> rightStack = new Stack<>();
        Stack<String> leftStack = new Stack<>();

        for(String str : inputString.split("")) {
            rightStack.push(str);
        }

        for(int i=0; i<commandCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if("L".equals(command)) {
                if(rightStack.isEmpty()) continue;
                leftStack.push(rightStack.pop());
            }
            else if("D".equals(command)) {
                if(leftStack.isEmpty()) continue;
                rightStack.push(leftStack.pop());
            }
            else if("B".equals(command)) {
                if(rightStack.isEmpty()) continue;
                rightStack.pop();
            }
            else if("P".equals(command)) {
                String addStr = st.nextToken();
                rightStack.push(addStr);
            }
        }

        while(!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }

        StringBuilder result = new StringBuilder();
        while(!leftStack.isEmpty()) {
            result.append(leftStack.pop());
        }

        System.out.println(result);
    }
}
