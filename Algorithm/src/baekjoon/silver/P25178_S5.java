package baekjoon.silver;

/*
입력:
    1. 첫째줄에 단어의 길이 N(2<=N<=100000)
    2. 둘째줄, 셋째줄 길이가 N인 알파벳 소문자 문자열
출력:
    1. 두 문자열이 조건을 만족하면 YES, 아니면 NO
문제:
    1. 한 단어를 재배열해 다른 단어를 만들 수 있어야 함 -> 각 모음의 개수가 같아야 함.
    2. 두 단어의 첫 글자와 마지막 글자는 서로 동일해야 함
    3. 각 단어에서 모음(aeiou) 을 제거한 문자열은 동일해야 함 -> 모음만 바뀌어야 한다.
로직:
    1. 모음을 제거하며 StringBuilder 에 추가하고 두 단어가 같은지 보면?
    2. 각 모음의 카운트를 Map 에 담아놓고 비교
문제점
    1. aabcde vs abcdea 두 문자열은 NO 가 되어야 함
    2. 모음을 없앤후 같다고 같은게 아니라 자음의 순서도 같아야 함. -> 자음의 인덱스를 sb에 넣고 다르면 NO 출력하면 되지 않나?
*/
import java.io.*;
import java.util.*;

public class P25178_S5 {

    static int N;
    static String first;
    static String second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        first = br.readLine();
        second = br.readLine();

        System.out.println(compareSpellingCount() && firstLastCompare() && removeCompare() ? "YES" : "NO");
    }

    static boolean compareSpellingCount() {
        // 1. 각 스펠링의 개수 비교
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            char a = first.charAt(i);
            char b = second.charAt(i);

            if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') map.put(a, map.getOrDefault(a, 0)+1);
            if(b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u') map.put(b, map.getOrDefault(b, 0)-1);
        }

        char[] cArr = {'a','e','i','o','u'};
        for(char c : cArr) {
            if(map.getOrDefault(c, 0) != 0) {
                return false;
            }
        }

        return true;
    }

    static boolean firstLastCompare() {
        return (first.charAt(0) == second.charAt(0)) && (first.charAt(N-1) == second.charAt(N-1));
    }

    static boolean removeCompare() {
        // aeiou 삭제 후 같아야 함
        String replaceA = first.replaceAll("[aeiou]", "");
        String replaceB = second.replaceAll("[aeiou]", "");

        return replaceA.equals(replaceB);
    }
}