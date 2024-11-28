package baekjoon.silver;

import java.io.*;

/**
 * 입력: 자연수 x
 * 출력: 문제 변환 수(정수), 3의 배수이면 YES, 아니면 NO
 * 로직: 1. 주어진 자연수의 모든 자리수를 더한다.
 *      2. 모든 자리수를 더한 값이 1의 자리가 될때까지 1을 반복한다.
 *      3. 마지막 1의 자리가 3의 배수인지 확인
 *      4. 몇 번 1번을 반복했는지, 3의 배수인지 출력
 * int a = character - '0';
 */
public class P1769_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;
        while(str.length() != 1){
            int value = 0;
            for(int i=0; i<str.length(); i++) {
                value += str.charAt(i) - '0';
            }
            str = String.valueOf(value);
            count++;
        }

        int result = Integer.parseInt(str);

        System.out.println(count);
        System.out.println((result % 3 == 0)? "YES" : "NO");

    }
}
