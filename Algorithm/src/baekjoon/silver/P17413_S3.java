package baekjoon.silver;

import java.io.*;

/**
 * 문제분석
 * - 주어진 문자열에서 단어를 뒤집는다.
 * - <> 사이에 있는 문자열은 태그로서 뒤집지 않는다.
 * -
 *
 * 문제 풀이
 * - 우선 문자열의 길이가 10,000 까지 가능. 배열보단 list 사용하는게 좋을 듯
 * - 문자열을 하나씩 돌면서 '<' 값이 나오면 '>' 값이 나올 때까지 그대로 StringBuilder에 저장하고
 * - '>' 가 나온 직후 혹은 공백이 나온 직후에는 다음 공백 혹은 '<' 가 나올때까지 저장하다가 나오면 뒤집어 저장
 */
public class P17413_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        StringBuilder totReverseStr = new StringBuilder();
        StringBuilder reverseStr = new StringBuilder();
        int sIdx = sb.length(); //태그 시작 인덱스(시작부터 태그아닌 경우 대비해서 마지막 인덱스 부여)
        int eIdx = 0; // 태그 종료 인덱스(태그 시작안했는데 종료일 수 없도록 0 부여)
        int blankIdx = 0; // 공백 인덱스

        for(int i=0; i<sb.length(); i++){
            // 태그 시작하면 여태까지 저장한 reverseStr 반대로 뒤집어서 totReverseStr 에 저장
            if(sb.charAt(i) == '<') {
                sIdx = i;
                eIdx = sb.length();
                blankIdx = 0;
                totReverseStr.append(reverseStr.reverse());
                reverseStr = new StringBuilder();
            }
            // 태그 끝나면 태그 시작 인덱스, 공백 인덱스 초기화
            else if(sb.charAt(i) == '>') {
                sIdx = 0;
                eIdx = i;
                blankIdx = 0;
            }
            // 공백인 경우 공백 인덱스 부여, 공백인 경우 여태까지 저장한 reverseStr 반대로 뒤집어서 totReverseStr 에 저장
            else if(sb.charAt(i) == ' ') {
                blankIdx = i;
                totReverseStr.append(reverseStr.reverse());
                reverseStr = new StringBuilder();
            }

            // 태그 시작 & 끝날때까지 그대로 문자열 저장
            if(i>=sIdx && i<=eIdx) totReverseStr.append(sb.charAt(i));
            // 공백인 경우 공백 그대로 저장
            else if(blankIdx != 0 && blankIdx == i) totReverseStr.append(sb.charAt(i));
            // 태그 종료 후 혹은 공백 직후 reverseStr에 문자열 1개씩 저장
            else if(sIdx==0 || sIdx == sb.length() || blankIdx > i) {
                reverseStr.append(sb.charAt(i));
            }

            // 마지막 인덱스에도 여태까지 저장한 reverseStr reverse 해서 totReverseStr 에 저장
            if(eIdx != sb.length()-1 && i == sb.length()-1) {
                totReverseStr.append(reverseStr.reverse());
            }
        }

        System.out.println(totReverseStr);
    }
}
