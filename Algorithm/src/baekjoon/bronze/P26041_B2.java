package baekjoon.bronze;

import java.io.*;

/**
 * 문제 분석
 * - 문자열로 받은 전화번호들의 시작을 다음 문자열로 받은 B로 시작하는 전화번호가 몇개인가
 *
 * 문제 풀이
 * - 문자열 A를 String 배열로 변환
 * - 그 중 문자열 B로 시작하는 문자열 개수 찾기
 * - String 의 startsWith 메서드 사용 해보기
 */
public class P26041_B2 {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] numbers = br.readLine().split(" ");
       String start = br.readLine();
       int count = 0;

       for(String number : numbers){
           if(!number.equals(start) && number.startsWith(start)) count++;
       }

       System.out.println(count);
   }
}
