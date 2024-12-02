package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 테스트 케이스 T
 *  2. 학교 숫자 정수 N(1<=N<=100)
 *  3. n줄에 걸쳐 학교이름 S, 술의 양 ㅣ
 * 출력:
 *  1. 술 소비가 가장 많은 학교의 이름
 * 로직:
 *  1. 최대값만 가져오면 되는거 아닌지?
 */
public class P11557_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            String maxScName = "";
            int maxAlInt = 0;
            for(int k=0; k<n; k++) {
               st = new StringTokenizer(br.readLine());
               String scName = st.nextToken();
               int alInt = Integer.parseInt(st.nextToken());
               if(maxAlInt < alInt) {
                   maxAlInt = alInt;
                   maxScName = scName;
               }
            }
            bw.write(maxScName+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
