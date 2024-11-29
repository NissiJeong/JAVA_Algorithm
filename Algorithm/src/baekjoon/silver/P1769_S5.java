package baekjoon.silver;

import java.io.*;

/**
 * 입력: 자연수 x
 * 출력: 문제 변환 수(정수), 3의 배수이면 YES, 아니면 NO
 * 로직: 1. 주어진 문자열을 String 변수에 저장
 *      2. 주어진 자연수의 모든 자리수를 더한다.
 *      2-1. 모든 자리수를 더한 값이 1의 자리가 될때까지 1을 반복한다.
 *      2-2. 반복문을 돌면서 string 변수 업데이트
 *      3. 마지막 1의 자리가 3의 배수인지 확인
 *      4. 몇 번 1번을 반복했는지, 3의 배수인지 출력
 * int a = character - '0';
 *
 * 우선 입력을 받을 수 있는 BufferedReader 와 출력할 수 있는 BufferedWriter 를 선언합니다.
 * 여기서는 큰 차이가 없겠지만 일반적으로 BufferedReader 가 빠르기 때문에 쓰고 있습니다.
 * BufferedReader 로 문자열을 읽어와서 String 변수에 담아줍니다.
 *
 * 몇 번 반복했는지 count 하기 위한 int 형 변수를 선언합니다.
 * String 변수의 길이가 1일 때 까지 반복할 반복문을 작성합니다.
 *
 * while 문 안에 모든 자리수의 값의 합을 저장할 int 형 변수를 선언해서 0으로 초기화
 * String 변수의 길이만큼 반복문을 실행하면서
 * 자리수 합을 더하는 int 변수에 모든 자리수의 합을 더해줍니다.
 * 자리수의 합을 구하는 방식은
 * 문자열의 각 자리수의 char 값을 가져와서 char 값인 '0' 을 빼준 값을 더해줍니다.
 * char - char 는 int 형!
 *
 * 반복문을 빠져나와서
 * String 변수에 각 자리 수를 더한 int 형을 저장해줍니다. String.valueOf(int)
 *
 * 마지막으로 count 를 1씩 증가시킵니다.
 *
 * while 문이 끝나면 String 변수를 int 로 변환하여 int 변수에 저장해주고
 * BufferedWriter 로 count write + \n 해주고
 * bw 로 삼항연산자 사용하여 result 값을 % 3 == 0 이면 YES 아니면 NO 를 출력
 *
 * 재귀가 오래 걸리는 이유
 * 이 문제 상에서는 거의 차이가 없다.
 * 메모리 상에서는 함수를 호출하는게 조금더 이점을 볼 수 있다.
 *
 * 이문제 같은 경우는 재귀로 하는게 아주 미세한 이점이 있을 수 있다.
 */
public class P1769_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        int count = 0;
        while(str.length() != 1){
            //str = String.valueOf(str.chars().map(i -> i-'0').sum());

            int value = 0;
            for(int i=0; i<str.length(); i++) {
                value += str.charAt(i) - '0';
            }
            str = String.valueOf(value);
            count++;
        }

        int result = Integer.parseInt(str);

        bw.write(count+"\n");
        bw.write((result % 3 == 0)? "YES" : "NO");
        bw.flush();
    }
}
