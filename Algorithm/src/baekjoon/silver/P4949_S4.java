package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 균형잡인 단어의 개수를 파악한다
 * - 균형은 (), [] 두 개의 괄호가 쌍을 잘 이루고 있는지 이다.
 * <p></p>
 * 문제풀이
 * - 스택에 괄호를 저장하고 같은 괄호가 있으면 삭제
 * - 최종적으로 스택이 비어있으면 균형 답힌 단어
 * - 각 문자열의 끝은 온점(.)
 */
public class P4949_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while(true) {

            str = br.readLine();

            if(".".equals(str)) break;

            sb.append(validateStr(str));
        }

        System.out.print(sb);
    }

    public static String validateStr(String str) {
        Stack<Character> valStack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '[') {
                valStack.push(c);
                continue;
            }

            if(c == ')') {
                if(valStack.isEmpty() || valStack.peek() != '(') valStack.push(c);
                else if(valStack.peek() == '(') valStack.pop();
            }
            else if(c == ']') {
                if(valStack.isEmpty() || valStack.peek() != '[') valStack.push(c);
                else if(valStack.peek() == '[') valStack.pop();
            }
        }

        if(valStack.isEmpty()) return "yes\n";
        else return "no\n";
    }
}
