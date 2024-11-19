package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 주어진 n 만큼 문자열이 주어진다.
 * - 문자열은 A,B 로 구성되어 있고 A,B 쌍을 이루는 단어를 찾아야 한다.
 * - 쌍은 단어 위로 지나가는 아치 선으로 이루는데 선이 겹치치 않고 모든 문자들이 쌍을 이뤄야 한다.
 *
 * 문제풀이
 * - 좋은 단어가 되는 조건
 *   우선 홀수면 짝이 이루어 지지 않는 문자가 있으니 짝수여야 함.
 *   문자들이 서로 감싸고 있거나(ex, ABBA) 연속해서 나오거나(ex, AABB)
 * - 위 조건들을 어떻게 구현할 것인가
 *
 * - 구현에 감이 안와서 구글링 힌트를 찾았음.
 * - 문자열 하나씩 돌면서 스택에 넣고
 * - 다음 문자열과 스택 마지막이 같은 문자면 스택에서 해당 문자 삭제
 * - 최종적으로 스택에 문자열 없으면 좋은 단어 아니면 이상한 단어
 */
public class P3986_S4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int j=0; j<str.length(); j++) {
                if(stack.isEmpty() || stack.peek() != str.charAt(j)) stack.push(str.charAt(j));
                else if(stack.peek() == str.charAt(j)) stack.pop();
            }

            if(stack.empty()) count++;
        }

        System.out.println(count);
    }
}