package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 모스부호로 들어온 문자열을 해석
 *
 * 문제풀이
 * - 모스부호를 map에 담아놓고
 * - 들어온 모스부호를 반복해서 돌면서 문자열 출력
 */
public class P29701_B2 {
    public static void main(String[] args) throws IOException {
        Map<String, String> mosMap = createMosMap();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            String mos = st.nextToken();
            System.out.print(mosMap.get(mos));
        }
    }

    static Map<String, String> createMosMap(){
        Map<String, String> rtnMap = new HashMap<>();
        rtnMap.put(".-", "A");
        rtnMap.put("-...", "B");
        rtnMap.put("-.-.", "C");
        rtnMap.put("-..", "D");
        rtnMap.put(".", "E");
        rtnMap.put("..-.", "F");
        rtnMap.put("--.", "G");
        rtnMap.put("....", "H");
        rtnMap.put("..", "I");
        rtnMap.put(".---", "J");
        rtnMap.put("-.-", "K");
        rtnMap.put(".-..", "L");
        rtnMap.put("--", "M");
        rtnMap.put("-.", "N");
        rtnMap.put("---", "O");
        rtnMap.put(".--.", "P");
        rtnMap.put("--.-", "Q");
        rtnMap.put(".-.", "R");
        rtnMap.put("...", "S");
        rtnMap.put("-", "T");
        rtnMap.put("..-", "U");
        rtnMap.put("...-", "V");
        rtnMap.put(".--", "W");
        rtnMap.put("-..-", "X");
        rtnMap.put("-.--", "Y");
        rtnMap.put("--..", "Z");
        rtnMap.put(".----", "1");
        rtnMap.put("..---", "2");
        rtnMap.put("...--", "3");
        rtnMap.put("....-", "4");
        rtnMap.put(".....", "5");
        rtnMap.put("-....", "6");
        rtnMap.put("--...", "7");
        rtnMap.put("---..", "8");
        rtnMap.put("----.", "9");
        rtnMap.put("-----", "0");
        rtnMap.put("--..--", ",");
        rtnMap.put(".-.-.-", ".");
        rtnMap.put("..--..", "?");
        rtnMap.put("---...", ":");
        rtnMap.put("-....-", "-");
        rtnMap.put(".--.-.", "@");

        return rtnMap;
    }
}
