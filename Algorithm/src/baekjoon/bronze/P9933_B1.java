package baekjoon.bronze;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 입력: 단어의 수 n, n개의 단어(2<=단어<=14, 홀수)
 * 출력: 비밀번호의 길이 & 가운제 글자
 * 로직:
 *  1. hashMap 선언
 *  2. 1..n 반복
 *  3. String, 거꾸로 String map 에 담기, value += 1
 *  4. map 반복하면서 value 2 인 값 찾기
 */
public class P9933_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> passMap = new HashMap<>();

        for(int i=0; i<n; i++) {
            StringBuilder pass = new StringBuilder(br.readLine());

            String word = pass.toString();
            String reverse = pass.reverse().toString();

            passMap.put(word, passMap.getOrDefault(word,0)+1);
            passMap.put(reverse, passMap.getOrDefault(reverse,0)+1);
        }

        String password = "";
        for(String key : passMap.keySet()) {
            if(passMap.get(key) == 2) {
                password = key;
                break;
            }
        }

        System.out.println(password.length() + " " + password.charAt(password.length()/2));
    }
}
