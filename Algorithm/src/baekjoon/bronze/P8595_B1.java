package baekjoon.bronze;

import java.io.*;

public class P8595_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] cArr = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        long sum = 0;
        for(int i=0; i<N; i++) {
            if(Character.isDigit(cArr[i])) {
                sb.append(cArr[i]);
            }
            else {
                if(sb.length() > 0) {
                    sum += Long.parseLong(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        // 마지막으로 남아있는 숫자 처리
        if (sb.length() > 0) {
            sum += Long.parseLong(sb.toString());
        }

        System.out.println(sum);
    }
}
