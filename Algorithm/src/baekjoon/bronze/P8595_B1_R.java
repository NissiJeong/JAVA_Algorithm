package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력:
    1. 단어의 길이 n
    2. 단어
출력:
    1. 숨어있는 히든 넘버의 합
로직:
    1.
 */
public class P8595_B1_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        long sum = 0;
        for(int i=0; i<n; i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                sb.append(c);
            }
            else {
                sum += Long.parseLong(sb.toString());
                sb.setLength(0);
            }
        }

        if(!sb.isEmpty()) {
            sum += Long.parseLong(sb.toString());
        }

        System.out.println(sum);
    }
}
