package baekjoon.gold;

/*
입력:
    1. 문자열 S(1<=S<=999)
    2. 문자열 T(2<=T<=1000 S<=T)
출력:
    1. S 를 T로 바꿀수 있으면 1, 아니면 0
문제:
    1. 문자열의 뒤에 A를 추가
    2. 문자열을 뒤집고 B를 추가
로직:
    1. A와 B의 차이 개수를 count
    2. StringBuilder 에 넣고
*/

import java.io.*;

public class P12904_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ssb = new StringBuilder(br.readLine());
        StringBuilder tsb = new StringBuilder(br.readLine());

        while(ssb.length() < tsb.length()) {
            if(tsb.charAt(tsb.length()-1) == 'A') tsb.deleteCharAt(tsb.length()-1);
            else if(tsb.charAt(tsb.length()-1) == 'B') {
                tsb.deleteCharAt(tsb.length()-1);
                tsb.reverse();
            }
        }

        System.out.println(tsb.compareTo(ssb)==0 ? 1 : 0);
    }
}
