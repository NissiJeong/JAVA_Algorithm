package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 괄호 (), {} 문자열 입력
 * 짝이 맞아야 올바른 괄호열
 * 괄호열이 중첩되는 경우 소괄호는 값을 *2 중괄호는 값 *3
 * 1. 올바른 괄호열인지 확인
 * 2. 옳다면
 *
 * 문제분석 및 풀이
 * - 스택, 최종 값 저장될 객체, 중간 값 저장될 객체
 * - 입력값 4개에 따라 분기처리
 * - ( -> 스택에 Push / 곱셈
 *
 * (()[[]])([])
 * (())
 *   2*(2 + 3)    = 2*2 + 2*3
 *   ( ( ) [ ] )
 * r 0 0 4 4 10 10
 * m 2 4 2 6 2  1
 */
public class PairProgramming_P2504_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputString = br.readLine();

        int returnInt = CorrectValueReturn(inputString);

        bw.write(returnInt + "");
        bw.flush();
    }

    public static int CorrectValueReturn(String inputString) {
        Stack<Character> charStack = new Stack<>();
        int multipleInt = 1;
        int returnInt = 0;

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
                // 잘못된 값인지 체크
                if(charStack.isEmpty() || charStack.peek() != '(') return 0;

                if(inputString.charAt(i-1) == '(') {
                    returnInt += multipleInt;
                }

                charStack.pop();

                multipleInt /= 2;
            }
            else if(c == ']') {
                // 잘못된 값인지 체크
                if(charStack.isEmpty() || charStack.peek() != '[') return 0;

                if(inputString.charAt(i-1) == '[') {
                    returnInt += multipleInt;
                }

                charStack.pop();

                multipleInt /= 3;
            }
        }

        if(!charStack.isEmpty()) return 0;
        return returnInt;
    }
}
