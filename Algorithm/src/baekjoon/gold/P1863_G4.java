package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. n (1<=n<50000)
 *  2. n 개의 x, y (1<=ㅌ<=1000000, 0<=y<=500000)
 * 출력:
 *  1. 최소 건물 개수
 * 로직:
 *  1. list 에 넣으면서 같은 값이 있으면 안넣고  0 이 나오면 초기회 해서 넣으면 안되나?
 */
public class P1863_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(y==0){
                count += stack.size();
                stack.clear();
            }
            else if(stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
            }
            else if(!stack.isEmpty() && stack.peek() > y) {
                while(!stack.isEmpty() && stack.peek() > y) {
                    stack.pop();
                    count++;
                }
                if(!stack.isEmpty() && stack.peek()<y)
                    stack.push(y);
                if(stack.isEmpty())
                    stack.push(y);
            }
        }

        count += stack.size();

        System.out.println(count);
    }
}
