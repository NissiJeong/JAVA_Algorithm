package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제분석
 * - 받은 int n 으로 각 문자열의 요소들을 반복한다.
 *
 * 문제풀이
 * - t번 반복하면서 문자열의 각 요소들을 가져와서 n 번씩 반복한다.
 */
public class P2675_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());


        while(t>0){
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String[] strArr = st.nextToken().split("");

            for(int i=0; i<strArr.length; i++){
                sb.append(strArr[i].repeat(n));
            }

            System.out.println(sb.toString());

            t--;
        }
    }
}
