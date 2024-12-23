package baekjoon.bronze;

/*
입력:
    1. 이진수 M의 자리수인 N(1<=N<=1000000)
    2. 이진수 M이 N자리만큼
    3. 나누는 수 2^K
출력:
    1. 이진수 M이 2^K 로 나누어지면 YES, 그렇지 않으면 NO 출력
문제:
    1. 이진수 M이 2^K 로 나누어 떨어지는지 판별하는 프로그램 작성
로직:
    1. 나누어 떨어진다?
    2. 2^0*0 + 2^1*0 + 2^2*0 ... + 2^7*1 / 2^6
    3. 2^2+2^1 / 2^2 -> 2(2+1) / 2^2
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P22950_B1_another {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int K = Integer.parseInt(br.readLine());

        int idx = K;
        int len = str.length();
        for(int i=0; i<len; i++) {
            if(str.charAt(len-i-1) == '1') {
                idx = i;
                break;
            }
        }

        if(idx >= K) System.out.println("YES");
        else System.out.println("NO");
    }
}