package baekjoon.bronze;

import java.io.*;

/**
 * 문제 분석
 * - 주어진 isPalindrome 함수와 recursion 함수를 이용하여 주어진 문자열마다 recursion 함수 실행 횟수를 카운트
 *
 * 문제 풀이
 * - int T 를 입력받아 T 만큼 반복하여 문자열 입력
 * - 문자열 입력 받을 때마다 주어진 isPalindrome 함수 호출
 * - 전역 변수로 선언된 count 를 recursion 함수 안에서 +1
 */
public class P25501 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            count = 0;
            System.out.println(isPalindrome(br.readLine()) + " " + count);
        }

        br.close();
    }

    public static int recursion(String s, int l, int r){
        // 함수 호출 할 때마다 +1 해야하기 때문에 가장 위에서 실행
        count++;
        if(l>r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
