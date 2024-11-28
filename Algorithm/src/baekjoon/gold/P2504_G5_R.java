package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 입력 : 괄호열 (()[[]])([])
 * 출력 : 괄호열의 연산 값 28
 * 로직 : 문자열 순회하며 올바른 괄호열인지 체크
 *       여는 괄호: ( [ , 닫는 괄호: ) ]
 *       () -> 2, [] -> 3  (X) -> 2 * 값(X)  [X] -> 3 * 값(X)  ()[] -> 2 + 3
 *       (()[]) -> 2*(2+3) 을 구현하는 것이 아니라 -> 분배법칙을 이용하여 2*2 + 2*3 을 구현한다.
 *       로직 정리:
 *          1. 문자열을 탐색하며 스택에 여는 괄호를 넣고, 여는 괄호를 만나면 임시값(분배곱셈처리하는애)에 *2, *3 을 한다.
 *          1-1. 만약 스택이 비어 있는데 닫는 괄호를 만나면 0 리턴
 *          2. 닫는 괄호가 나왔을 때, 스택의 최상단 값과 비교 -> 괄호가 매칭되지 않으면 0 리턴
 *          2-1. 만약 맞는 값이 나오면 임시값 더하기
 *          2-2. 닫는 괄호 연산 끝에 스택 최상단 값 없애고 임시값 /2, /3
 *          3. 탐색이 끝난 후 스택이 비어 있으면 결과값, 스택에 값이 남아 있으면 0 출력
 */
public class P2504_G5_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();

        int returnInt = validateString(inputString);

        System.out.print(returnInt);
    }

    public static int validateString(String inputString) {
        Stack<Character> charStack = new Stack<>();
        int multipleInt = 1;
        int resultInt = 0;

        for(int i=0; i<inputString.length(); i++) {
            char c = inputString.charAt(i);

            if(c == '(') {
                charStack.push(c);
                multipleInt *= 2;
            }
            else if(c == '[') {
                charStack.push(c);
                multipleInt *= 3;
            }
            else if(c == ')') {
                if(charStack.isEmpty() || charStack.peek() != '(') return 0;

                if(inputString.charAt(i-1) == '(') resultInt += multipleInt;

                charStack.pop();
                multipleInt /= 2;
            }
            else if(c == ']') {
                if(charStack.isEmpty() || charStack.peek() != '[') return 0;

                if(inputString.charAt(i-1) == '[') resultInt += multipleInt;

                charStack.pop();
                multipleInt /= 3;
            }
        }

        if(!charStack.isEmpty()) resultInt = 0;
        return resultInt;
    }
}
