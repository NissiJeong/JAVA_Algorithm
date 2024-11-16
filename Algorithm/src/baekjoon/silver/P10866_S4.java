package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 입력 받은 n 만큼 입력 받은 문자열대로 덱에 입력, 출력 하는 기능 구현
 *
 * 문제풀이
 * Deque 구현
 */
public class P10866_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> intDeque = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            switch (command){
                case "pop_front":
                    if(intDeque.isEmpty()) {
                        System.out.println("-1");
                        continue;
                    }
                    System.out.println(intDeque.pollFirst());
                    break;
                case "pop_back":
                    if(intDeque.isEmpty()) {
                        System.out.println("-1");
                        continue;
                    }
                    System.out.println(intDeque.pollLast());
                    break;
                case "size":
                    System.out.println(intDeque.size());
                    break;
                case "empty":
                    if(intDeque.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "front":
                    if(intDeque.isEmpty()) {
                        System.out.println("-1");
                        continue;
                    }
                    System.out.println(intDeque.peekFirst());
                    break;
                case "back":
                    if(intDeque.isEmpty()) {
                        System.out.println("-1");
                        continue;
                    }
                    System.out.println(intDeque.peekLast());
                    break;
                case "push_front":
                    x = Integer.parseInt(st.nextToken());
                    intDeque.addFirst(x);
                    break;
                case "push_back":
                    x = Integer.parseInt(st.nextToken());
                    intDeque.addLast(x);
                    break;
            }
        }
    }
}
