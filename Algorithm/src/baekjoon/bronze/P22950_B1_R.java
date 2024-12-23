package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력:
    1. 이진수 M 의 자리수인 N(1<=N<=1000000)
    2. 이진수 M 이 N 자리만큼
    3. 나누는 수 2^K (0<=K<=1000000)
출력:
    1. M이 2^K 으로 나누어 떨어지면 YES, 아니면 NO
 */
public class P22950_B1_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        int idx = str.length()-1;
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(str.length()-i-1);
            if(c=='1') {
                idx = i;
                break;
            }
        }

        if(k == 0)
            System.out.println("YES");
        else if(idx >= k)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
