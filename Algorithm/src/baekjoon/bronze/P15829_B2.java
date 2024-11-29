package baekjoon.bronze;

import java.io.*;
/**
 * 입력: 문자열의 길이 L, 문자열
 * 출력: 계산이 완료된 해시 값
 * 로직:
 *  1. 1~L 반복
 *  1-1. 각 문자열의 자리수의 char - 'a' + 1 을 해주면 고유번호 구할 수 있음
 *  1-2. 고유번호 * 31^i 해주고 다 더해줌
 *  2. 최종적으로 1234567891 로 나눠준다.
 */
public class P15829_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String S = br.readLine();
        long result = 0;
        long pow = 1;
        for(int i = 0; i < L; i++) {
            result += ((S.charAt(i) - 96) * pow);
            //pow는 31을 매번 곱해준다. 곱해줄때마다 1234567891을 나눠주면 long을 넘지 않을 것이다.
            pow = (pow * 31) % 1234567891;
        }
        System.out.println(result % 1234567891);
    }
}
