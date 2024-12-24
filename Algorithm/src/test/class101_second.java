package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class class101_second {
    /*
    올바른 괄호열 만들기
    1. 빈문자열은 올바른 괄호 문자열
    2. A가 올바른 괄호 문자열이면 (A)도 올바른 괄호 문자열
    3. A,B 가 올바른 괄호 문자열이면 AB도 올바른 괄호 문자열
    두 배열의 문자열을 하나씩 선택해서 올바른 괄호를 만드는 방법의 개수

    1. arr1 에서 ')' 로 시작하는 애들 제거
    2. arr2 에서 '(' 로 끝나는 애들 제거
    3. arr1 에서 완벽한 애들은 arr2 에서 완벽한 애들을 만나야 함.
    4. arr1 에서 불완전한 애들은 arr2 에서 불완전한 애들을 만나야 함.

    로직
    1. arr1 에서 ')' 로 시작하지 않고 완전한 애들은 list1 에 저장
    1-1.                         불완전한 애들은 list2 에 저장
    2. arr2 에서 '(' 로 끝나지 않고 완전한 애들은 list3 에 저장
    2-2                         불완전한 애들은 list4 에 저장
    */
    class Solution {
        public long solution(String[] arr1, String[] arr2) {
            long answer = -1;

            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            List<String> list3 = new ArrayList<>();
            List<String> list4 = new ArrayList<>();
            for(int i=0; i<arr1.length; i++) {
                if(arr1[i].charAt(0) != ')') {
                    if(isfull(arr1[i])) list1.add(arr1[i]);
                    else list2.add(arr1[i]);
                }
            }

            for(int i=0; i<arr2.length; i++) {
                if(arr2[i].charAt(0) != ')') {
                    if(isfull(arr2[i])) list3.add(arr2[i]);
                    else list4.add(arr2[i]);
                }
            }

            int sum = list1.size() * list2.size();

            for(int i=0; i<list2.size(); i++) {
                for(int j=0; j<list4.size(); j++) {
                    if(isfull(list1.get(i)+list2.get(j))) sum++;
                }
            }

            answer = sum;

            return answer;
        }

        boolean isfull(String str) {
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if(!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                    stack.pop();
                }
                else
                    stack.push(c);
            }

            return stack.isEmpty();
        }
    }
}
