package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 단어의 개수 N
 *  2. n개의 줄 단어 1개씩(<=50)
 * 출력:
 *  1. 조건에 따라 정렬하여 출렬
 * 로직:
 *  1. 길이가 짧은 것 부터
 *  2. 같으면 사전 순
 *  3. 중복된 단어는 하나만 남기고 제거(set에 저장?)
 *      상세로직:
 *          1. 1..n -> set.add(str)
 *          2. set -> list
 *          3. list 정렬 -> 길이 내림차순, 문자열 내림차순
 */
public class P1181_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> wordSet = new HashSet<>();
        while(N-- >0) {
            String word = br.readLine();
            wordSet.add(word);
        }

        List<String> wordList = new ArrayList<>(wordSet);
        wordList.sort((o1, o2) -> {
            if (o1.length() - o2.length() == 0) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for(String word : wordList) sb.append(word).append("\n");

        System.out.print(sb);
    }
}
