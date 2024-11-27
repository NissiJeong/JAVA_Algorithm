package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 문자별로 겹치지 않게 쌍을 이루면서 삭제를 하는 문제
 * - 100000 까지 길이라서 효율적인 자료구조 사용
 * <p></p>
 * 문제풀이
 * - 한방향으로 문자를 넣으며 다음 문자가 이전 문자와 같다면 삭제 다르다면 다시 추가
 * - 마지막에 해당 자료구조가 비어 있으면 좋은 단어
 * - 한방향으로 입력, 삭제 하는 자료구조: 스택 혹은 Deque 를 한방향으로 사용
 */
public class P3986_S4_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int goodCnt = 0;
        Stack<Character> cStack;

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            cStack = new Stack<>();

            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                if(cStack.isEmpty() || cStack.peek() != c) cStack.push(c);
                else if(cStack.peek() == c) cStack.pop();
            }

            if(cStack.isEmpty()) goodCnt++;
        }

        System.out.print(goodCnt);
    }
}
