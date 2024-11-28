package baekjoon.silver;

import java.util.*;
import java.io.*;

/**
 * 입력: 명령의 수 n(1<=n<=10000), n개의 명령
 * 출력: 출력 명령마다 맞는 값 출력
 * 로직
 *  1. 정수를 저장하는 큐 구현
 *  2. n 만큼 반복문 실행하면서 명령어 입력
 *  3. 명령어 대로 큐에 대한 연산 구현
 *  4. 출령 명령어 입력되면 값 출력
 */
public class P10845_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> intQueue = new LinkedList<>();
        int k = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command) {
                case "push":
                    k = Integer.parseInt(st.nextToken());
                    intQueue.add(k);
                    break;
                case "pop":
                    if(intQueue.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(intQueue.poll());
                    break;
                case "size":
                    System.out.println(intQueue.size());
                    break;
                case "empty":
                    System.out.println(intQueue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if(intQueue.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(intQueue.peek());
                    break;
                case "back":
                    if(intQueue.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(k);
                    break;
            }
        }
    }
}
