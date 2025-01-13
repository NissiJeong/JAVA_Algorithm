package baekjoon.silver;

/*
입력:
    1. 첫줄에 n(1<=n<=100000)
    2. n개의 줄 1이상 n 이하의 정수(중복x)
출력:
    1. 수열을 만들기 위한 연산 한줄에 한개씩 출력
문제:
    1. 주어진 1~N 까지 stack 에 넣고 뺐을 때 주어진 순열을 만들 수 있는지?
    2. 넣을 때는 오름차순 정렬
로직:
    1. +,-의 개수 만큼 주어진 숫자를 만들 수 있는지? 없으면 NO 출력
*/

import java.io.*;
import java.util.*;

public class P1874_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        int idx = 0;
        for(int i=1; i<=N; i++) {
            int next = Integer.parseInt(br.readLine());
            while(true) {
                if(stack.isEmpty() || next>stack.peek()) {
                    idx++;
                    stack.push(idx);
                    sb.append("+").append("\n");
                }
                else if(next<stack.peek()) {
                    sb.setLength(0);
                    sb.append("NO");
                    flag = false;
                    break;
                }

                if(next==stack.peek()) {
                    stack.pop();
                    sb.append("-").append("\n");
                    break;
                }
            }
            if(!flag) break;
        }

        System.out.println(sb);
    }
}