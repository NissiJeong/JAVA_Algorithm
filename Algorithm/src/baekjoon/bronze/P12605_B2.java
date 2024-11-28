package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 입력: 테스트 케이스 개수 n / 스페이스로 띄어진 문자열 n개
 * 출력: 각 문자열을 뒤집어서 출력
 * 로직: StringTokenizer 로 입력 받아서 스택에 문자열 저장
 *      스택을 하나씩 빼서 출력
 */
public class P12605_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            Stack<String> strStack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            while(st.hasMoreTokens()) {
                strStack.push(st.nextToken());
            }

            sb.append("Case #").append(i+1).append(": ");
            while(!strStack.isEmpty()) {
                sb.append(strStack.pop()).append(" ");
            }

            System.out.print(sb);
        }
    }
}
