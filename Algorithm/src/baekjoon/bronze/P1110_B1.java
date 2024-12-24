package baekjoon.bronze;

import java.io.*;

public class P1110_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int newNum = 0;
        int temp = 0;
        int count = 0;
        temp = N;

        while(N!=newNum) {
            count++;
            int f = temp/10;
            int s = temp%10;
            newNum = Integer.parseInt(s+""+((f+s)%10));
            temp = newNum;
        }
        if(N==0) count = 1;

        System.out.println(count);
    }
}
