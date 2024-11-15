package baekjoon.silver;

import java.io.*;

/**
 * 문제 분석
 * - 3의 n제곱 만큼의 문자열 길이를 3등분
 * - 가운데 문자열 공백 처리
 * - 각 문자열의 길이가 1일 때 까지 반복
 *
 * 풀이 방법
 * - 문자열과 시작점, 끝점 인덱스를 전달하는 함수 생성
 * - 가운데 삭제 후 왼쪽 인덱스, 오른쪽 인덱스 계산
 * - 왼쪽, 오른쪽 나눠가며 함수 재귀로 호출
 *
 */
public class P4779_S3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        StringBuilder cantor = new StringBuilder("---");
        for(int i=0; i<n; i++) {

        }
        //cantorFunction(k);
    }


}
