package baekjoon.bronze;

/*
입력:
    1. 문자열 S
    2. 문자열 P
출력:
    1. P 가 S의 부분문자열이면 1, 아니면 0
로직:
    1. 그냥 S를 P로 split 하면 되는거 아닌가?
    2. 시간초과
    찾아보니 KMP 알고리즘을 써야한다는데.. 내일 해보자
*/

import java.io.*;

public class P16916_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        String[] arr = S.split(P);

        if(arr.length > 1) System.out.println(1);
        else System.out.println(0);
    }
}