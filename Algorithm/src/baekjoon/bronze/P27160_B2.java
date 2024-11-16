package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - int n 과 n개의 문자열 + 숫자가 주어짐.
 * - 각 문자열이 키 값으로 해당 문자열의 숫자가 하나라도 5이면 yes 출력
 *
 * 문제풀이
 * - 주어진 n 만큼 반복해서 돌며
 * - map 에 문자열과 숫자를 저장
 * - 그 중 숫자가 5가 되면 yes를 출력
 *
 */
public class P27160_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> strMap = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            strMap.put(str, strMap.getOrDefault(str, 0)+cnt);
        }

        if(strMap.containsValue(5)) System.out.println("YES");
        else System.out.println("NO");
    }
}
