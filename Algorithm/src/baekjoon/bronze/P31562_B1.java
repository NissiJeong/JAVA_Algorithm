package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 입력
 *  1. 노래의 개수 n, 맞히기 시도 개수 m
 *  2. n개의 노래제목 길이 t, 노래 제목 s, 7개 음이름
 *  3. m개의 정환이 맞히기 시도할 노래의 첫 세 음이름
 * 출력
 *  1. 정환의 세음과 노래의 첫 세음이 같은 개수가 1개: 노래제목 / 2개이상: ? / 0개: !
 * 로직
 *  1. 1..n 반복 -> 노래와 노래 정보 배열에 저장
 *  2. 1..m 반복 -> 배열에 저장된 곡 반복하면서 첫 세 음과 동일하다면 그 개수만큼 조건에 맞는 내용 출력
 */
public class P31562_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] songArr = new String[n][9];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = 0;
            while(st.hasMoreTokens()) {
                songArr[i][k] = st.nextToken();
                k++;
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            String answer1 = st.nextToken();
            String answer2 = st.nextToken();
            String answer3 = st.nextToken();

            int anCnt = 0;
            String answer = "";
            for(int k=0; k<n; k++) {
                if(songArr[k][2].equals(answer1) && songArr[k][3].equals(answer2) && songArr[k][4].equals(answer3)) {
                    anCnt++;
                    answer = songArr[k][1];
                }
            }

            if(anCnt == 1) System.out.println(answer);
            else if(anCnt >= 2) System.out.println("?");
            else System.out.println("!");
        }
    }
}
