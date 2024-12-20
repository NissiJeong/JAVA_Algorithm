package baekjoon.silver;

import java.io.*;

public class P10610_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();
        int[] numArr = new int[10];
        int total = 0;
        for(int i=0; i<numStr.length(); i++) {
            int tNum = Integer.parseInt(numStr.substring(i,i+1));
            numArr[tNum] += 1;
            total += tNum;
        }

        if(!numStr.contains("0") || total%3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            while(numArr[i] > 0) {
                sb.append(i);
                numArr[i]--;
            }
        }

        System.out.println(sb);
    }
}
