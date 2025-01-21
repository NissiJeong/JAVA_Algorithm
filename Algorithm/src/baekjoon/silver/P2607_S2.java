package baekjoon.silver;/*
입력:
    1. 단어의 개수(<=100)
    2. 단어(len<=10)
출력:
    1. 입력으로 주어진 첫 번째 단어와 비슷한 단어가 몇 개인지
문제:
    1. 두가지 조건, 두개의 단어가 같은 종유릐 문자로 이루어져 있다.
    2. 같은 문자는 같은 개수 만큼 있다.
    3. 두 문자가 구성이 같거나, 한 단어에서 한 문자를 더하거나, 빼거나, 하나의 문자를 다른 문자로 바꾸어 
       나머지 한 단어와 같은 구성을 갖게 되는 경우에 두 단어를 서로 비슷한 단어라고 한다.
로직:
    1. 100개 안되는 단어 다 하나씩 비교 해야 할듯
*/

import java.io.*;

public class P2607_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String std = br.readLine();

        int count = 0;
        for(int i=0; i<N-1; i++) {
            String target = br.readLine();
            boolean check = isSimilar(std, target);
            System.out.println(target+":"+check);
            if(check) count++;
        }

        System.out.println(count);
    }

    static boolean isSimilar(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) >= 2) {
            return false;
        }

        int[] freq = new int[26];
        for (char c : str1.toCharArray()) {
            freq[c - 'A']++;
        }
        for (char c : str2.toCharArray()) {
            freq[c - 'A']--;
        }

        int add = 0;
        int remove = 0;
        for (int f : freq) {
            if (f > 0) {
                add += f;
            } else if (f < 0) {
                remove -= f;
            }
        }

        return add <= 1 && remove <= 1 && (add + remove) <= 2;
    }
}