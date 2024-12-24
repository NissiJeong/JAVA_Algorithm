package baekjoon.bronze;

/*
입력
    1: 알파벳 대문자로 이루어진 단어(2<=len<=15)
출력
    1: 다이얼을 걸기 위한 최소 시간
문제
    1. 단순 구현
    2. 알파벳과 숫자를 담아놓고
    3. 알파벳이 주어졌을때 해당 알파벳의 숫자와 시간을 구한다
*/
import java.io.*;
import java.util.*;

public class P5622_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = Map.ofEntries(
                Map.entry('A', 3), Map.entry('O', 7),
                Map.entry('B', 3), Map.entry('P', 8),
                Map.entry('C', 3), Map.entry('Q', 8),
                Map.entry('D', 4), Map.entry('R', 8),
                Map.entry('F', 4), Map.entry('S', 8),
                Map.entry('G', 5), Map.entry('T', 9),
                Map.entry('H', 5), Map.entry('U', 9),
                Map.entry('I', 5), Map.entry('V', 9),
                Map.entry('J', 6), Map.entry('W', 10),
                Map.entry('K', 6), Map.entry('X', 10),
                Map.entry('L', 6), Map.entry('Y', 10),
                Map.entry('M', 7), Map.entry('Z', 10),
                Map.entry('N', 7), Map.entry('E', 4)
        );

        String str = br.readLine();
        int sum = 0;
        for(int i=0; i<str.length(); i++) {
            char s = str.charAt(i);
            sum += map.get(s);
        }

        System.out.println(sum);
    }
}