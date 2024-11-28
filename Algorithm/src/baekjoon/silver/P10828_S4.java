package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 스택을 구현한다.
 */
public class P10828_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> intStack = new Stack<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")) {
                int k = Integer.parseInt(st.nextToken());
                intStack.push(k);
            }
            else if(command.equals("pop")) {
                if(intStack.isEmpty()) {
                    System.out.println("-1");
                    continue;
                }
                System.out.println(intStack.pop());
            }
            else if(command.equals("size")) System.out.println(intStack.size());
            else if(command.equals("empty")) System.out.println(intStack.isEmpty() ? 1 : 0);
            else if(command.equals("top")) {
                if(intStack.isEmpty()) {
                    System.out.println("-1");
                    continue;
                }
                System.out.println(intStack.peek());
            }
        }
    }
}
