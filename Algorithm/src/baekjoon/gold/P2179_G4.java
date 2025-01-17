package baekjoon.gold;

import java.io.*;
import java.util.*;

public class P2179_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        Map<String, Integer> originalIndexMap = new HashMap<>();

        // 입력 처리 및 인덱스 저장
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            arr[i] = word;
            originalIndexMap.put(word, i);
        }

        // 사전순 정렬
        Arrays.sort(arr);

        int maxPrefixLength = 0; // 최장 접두사 길이
        String firstWord = "";  // 결과 단어 1
        String secondWord = ""; // 결과 단어 2

        // 인접 단어 비교
        for (int i = 0; i < N - 1; i++) {
            String currentWord = arr[i];
            String nextWord = arr[i + 1];

            String commonPrefix = findCommonPrefix(currentWord, nextWord);
            int prefixLength = commonPrefix.length();

            if (prefixLength > maxPrefixLength) {
                maxPrefixLength = prefixLength;

                // 입력 순서에 따라 정렬
                if (originalIndexMap.get(currentWord) < originalIndexMap.get(nextWord)) {
                    firstWord = currentWord;
                    secondWord = nextWord;
                } else {
                    firstWord = nextWord;
                    secondWord = currentWord;
                }
            }
            else if (prefixLength == maxPrefixLength) {
                // 기존 단어의 입력 순서
                int firstIndex = originalIndexMap.get(firstWord);
                int secondIndex = originalIndexMap.get(secondWord);

                // 현재 단어들의 입력 순서
                int currentFirstIndex = originalIndexMap.get(currentWord);
                int currentSecondIndex = originalIndexMap.get(nextWord);

                // 입력 순서 정렬
                if (currentFirstIndex > currentSecondIndex) {
                    int temp = currentFirstIndex;
                    currentFirstIndex = currentSecondIndex;
                    currentSecondIndex = temp;

                    String tempWord = currentWord;
                    currentWord = nextWord;
                    nextWord = tempWord;
                }

                // 조건에 따라 단어 갱신
                if (currentFirstIndex < firstIndex ||
                        (currentFirstIndex == firstIndex && currentSecondIndex < secondIndex)) {
                    firstWord = currentWord;
                    secondWord = nextWord;
                }
            }
        }

        System.out.println(firstWord);
        System.out.println(secondWord);
    }

    // 두 문자열의 공통 접두사를 찾는 함수
    static String findCommonPrefix(String str1, String str2) {
        int maxLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < maxLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }

        return str1.substring(0, maxLength);
    }
}
