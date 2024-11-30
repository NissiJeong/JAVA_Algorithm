package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. 테스트 케이스 t
 *  2. 의상수 n(0<=n<=30)
 *  3. 의상 이름 + ' ' + 의상 종류
 * 출력: 1개 이상이라도 옷을 걸치는 것이 최대 몇 번?
 * 로직:
 *  1. 의상의 개수 n 개 중 종류 m 개를 선택할 수 있는 집합을 구한다
 *  2. 부분집합의 개수를 구한다.
 *  3. 옷의 종류별 몇 개의 옷이 있는지 카운트를 해야한다.
 *  4. map 에 담고 키에 옷이름 값에 옷 종 넣기
 */
public class P9375_S3 {

    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            Map<String, Integer> clothes = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                String cName = st.nextToken();
                String cCase = st.nextToken();

                clothes.put(cCase, clothes.getOrDefault(cCase, 1)+1);
            }

            int result = 1;
            for(String key : clothes.keySet()) {
                dp = new int[clothes.get(key)+1][2];
                result *= bf(clothes.get(key), 1);
            }

            bw.write(result-1+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int bf(int n, int m) {
        if(n==m || m==0) return dp[n][m] = 1;

        return dp[n][m] = bf(n-1, m-1) + bf(n-1, m);
    }
}
