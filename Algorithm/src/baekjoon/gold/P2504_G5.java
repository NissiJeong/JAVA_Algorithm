package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 올바른 괄호열을 구하고 () = 2 [] = 3 으로 계산하여 계산식의 값을 나타내라
 *
 * 문제풀이
 * - 올바른 괄호열인지는 스택을 이용하면 되긴 한데
 * - ( 으로 시작했는데 ) 이 안나오면 2* , [ 으로 시작했는데 ] 안나오면 3*
 * - ( 으로 시작했는데 ) 이 나오면 2+ , [ 으로 시작했는데 ] 나오면 2+
 * - 최종적으로 스택이 안비어 있으면 0 출력, 아니면 계산 값 출력
 *
 * - 숫자의 덧셈과 곱셈을 어떻게 자료구조에 넣고 실행시켜야 할지 감이 안잡힘...
 */
public class P2504_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> cStack = new Stack<>();
        int result = 0;
        int value = 1;
        //연산 카운트
        int cCount = 0;

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            // '(' 를 만난 경우
            if(c == '(') {
                cCount++;
                // 최초이면
                if(value == 1) value = 2;
                // stack 이 비어있지 않고(아직 연산이 안끝났고) 이전 값이 ')' 혹은 ']' 로 끝났으면 +2
                else if(!cStack.isEmpty() && (str.charAt(i-1) == ')' || str.charAt(i-1) == ']')) {
                    cCount = 0;
                    value += 2;
                }
                cStack.push(c);
            }
            else if(c == '[') {
                cCount++;
                // 최초이면
                if(value == 1) value = 3;
                    // stack 이 비어있지 않고(아직 연산이 안끝났고) 이전 값이 ')' 혹은 ']' 로 끝났으면 +3
                else if(!cStack.isEmpty() && (str.charAt(i-1) == ')' || str.charAt(i-1) == ']')) {
                    cCount = 0;
                    value += 3;
                }
                cStack.push(c);
            }

            // ')' 을 만난 경우
            if(c == ')') {
                cCount--;
                // 직전 스택의 값이 ( 로 끝난 경우
                if(cStack.peek() == '('){
                    // 해당 괄호 없애고
                    cStack.pop();
                    // 괄호 없앤 뒤 stack 이 비어 있거나 직전 값이 ( 이 아니면 *2
                    if(cStack.isEmpty() || str.charAt(i-1) != '(') value *= 2;

                    // 괄호가 끝나면 result 에 값 저장
                    if(cStack.isEmpty() || cCount == 0)  {
                        result += value;
                        // value 초기화
                        value = 1;
                    }

                }
            }
            // ']' 을 만난 경우
            else if(c == ']') {
                cCount--;
                // 직전 결과 [ 로 끝난 경우
                if(cStack.peek() == '[') {
                    cStack.pop();

                    // 괄호 없앤 뒤 stack 이 비어 있거나 직전 값이 [ 이 아니면 *3
                    if(cStack.isEmpty() || str.charAt(i-1) != '[') value *= 3;

                    // 괄호가 끝나면 result 에 값 저장
                    if(cStack.isEmpty() || cCount == 0) {
                        result += value;
                        // value 초기화
                        value = 1;
                    }

                }
            }

            System.out.println("result = " + result);
        }

        if(!cStack.isEmpty()) result = 0;
        System.out.println(result);
    }
}
