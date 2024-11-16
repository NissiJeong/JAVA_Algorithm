package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 숫자 n 이 주어지고 4n 줄 만큼의 문자열이 주어진다.
 * - 첫번째 줄은 4, 두번째 6, 세번째 4, 마지막 10을 나타낸다.
 * - 각자 문자열의 숫자의 차가 12 이하인지 아닌지 구해야 함.
 *
 * 문제풀이
 * - 4n만큼 반복문을 돌면서 문자열을 받는다.
 * - 4n-3: 4 / 4n-2: 6 / 4n-1: 4 / 4n: 10
 * - 각 문자열과 숫자는 Map 에 담아가며 시간을 계산
 * - 마지막에 map 에 있는 시간들의 최대 최소값을 구해서 12 이하로 차이나면 Yes 아니면 No 출력
 *
 */
public class P25593_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> timeMap = new HashMap<>();
        int time = 0;

        for(int i=1; i<=4*n; i++){
            st = new StringTokenizer(br.readLine());
            if(i%4==3 || i%4==1) time = 4;
            else if(i%4==2) time = 6;
            else time = 10;

            for(int j=0; j<7; j++){
                String name = st.nextToken();
                if(!name.equals("-")) timeMap.put(name, timeMap.getOrDefault(name, 0)+time);
            }
        }

        int maxTime = 0;
        int minTime = Integer.MAX_VALUE;

        for(String name : timeMap.keySet()){
            if(timeMap.get(name) > maxTime) maxTime = timeMap.get(name);
            if(timeMap.get(name) < minTime) minTime = timeMap.get(name);
        }

        if(maxTime - minTime > 12) System.out.println("No");
        else System.out.println("Yes");
    }
}
