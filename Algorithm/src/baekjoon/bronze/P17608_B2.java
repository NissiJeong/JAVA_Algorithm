package baekjoon.bronze;

import java.io.*;

/**
 * 입력: 막대기의 수 n(2<=n<=100000), 막대기 n개의 높이
 * 출력: 오른쪽에서 보이는 막대의 개수
 * 로직: n개의 숫자만큼 반복문 거꾸로 실행
 *      뒤에서부터 최대값을 찾고 갱신 될 때마다 카운트
 */
public class P17608_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] intArr = new int[n];

        for(int i=n-1; i>=0; i--) {
            intArr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int max = 0;
        for(int i=0; i<n; i++) {
            if(intArr[i] > max) {
                count++;
                max = intArr[i];
            }
        }

        System.out.print(count);
    }
}
