package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 입력
 *  1. 문제풀이개수 P, 입학연도 Y, 성씨 S
 *  2. 두번째, 세번째 팀원의 정보 P2,Y2,S2 / P3,Y3,S3
 * 출력
 *  1. 첫번째 방법 팀명 String
 *  2. 두번째 방법 팀명 String
 * 로직
 *  1. 세 팀원의 p, y, s 를 입력 받는다.
 *  2. y-> int[] , p + ' ' + s -> 공백을 두고 list 에 저장
 *  3. 연도 오름차순 정렬, map p를 기준으로 정렬
 *
 */
public class P28114_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] yearArr = new int[3];
        List<String> pSList = new ArrayList<>();

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) % 100;
            String s = st.nextToken().split("")[0];

            yearArr[i] = y;
            pSList.add(p+" "+s);
        }

        Arrays.sort(yearArr);
        pSList.sort((String s1, String s2) -> {
            return Integer.parseInt(s2.split(" ")[0]) - Integer.parseInt(s1.split(" ")[0]);
        });

        for(int a : yearArr) System.out.print(a);
        System.out.println();
        pSList.forEach(x -> System.out.print(x.split(" ")[1]));
    }
}
