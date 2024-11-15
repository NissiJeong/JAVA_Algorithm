package baekjoon.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제분석
 * - 입력 받은 문자열의 부분 문자열의 개수를 출력
 * - 서로 다른 부분 문자열들의 개수
 *
 * 문제 풀이
 * - 부분 문자열들은 for문을 돌면서 만든다.
 * - 주어진 문자열의 길이가 5, 부분 문자열의 길이가 3인 경우 5-3+1 인덱스까지 부분 문자열을 만들 수 있다.
 * - 만들어진 부분 문자열을 map 에 키 값으로 담고 해당 keySet()의 길이를 구하는 것으로 풀이 해보자
 */
public class P11478_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        Map<String, Integer> strMap = new HashMap<>();

//        for(int i=1; i<=len; i++){
//            for(int j=0; j<len; j++){
//                if(j+i <= len)  strMap.put(str.substring(j, j+i), 1);
//            }
//        }

        for(int i=0; i<len; i++){
            for(int j=i+1; j<=len; j++) strMap.put(str.substring(i, j), 1);
        }

        System.out.println(strMap.keySet().size());
    }
}
