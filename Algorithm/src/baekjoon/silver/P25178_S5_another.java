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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P25178_S5_another {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        String second = br.readLine();

        StringBuilder sbFirst = new StringBuilder();
        StringBuilder sbSecond = new StringBuilder();

        Map<Character, Integer> fMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for(int i=0; i<N; i++) {
            char c = first.charAt(i);
            if(c != 'a' && c != 'e' && c != 'i' && c != 'o'&& c != 'u'){
                sbFirst.append(c);
            } else {
                fMap.put(c, fMap.getOrDefault(c,0)+1);
            }
        }

        for(int i=0; i<N; i++) {
            char c = second.charAt(i);
            if(c != 'a' && c != 'e' && c != 'i' && c != 'o'&& c != 'u'){
                sbSecond.append(c);
            } else {
                sMap.put(c, sMap.getOrDefault(c,0)+1);
            }
        }

        boolean flag = true;
        char[] chArr = {'a','e','i','o','u'};
        for(char c : chArr) {
            if(fMap.getOrDefault(c, 0) != sMap.getOrDefault(c, 0)) {
                flag = false;
                break;
            }
        }

        if(!flag) {
            System.out.println("NO");
            return;
        }
        String result = "";
        if((first.charAt(0) != second.charAt(0)) ||
                (first.charAt(first.length()-1) != second.charAt(second.length()-1)) ) {
            result = "NO";
        }
        else if(sbFirst.compareTo(sbSecond) == 0) result = "YES";
        else result = "NO";

        System.out.println(result);
    }
}