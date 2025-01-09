package baekjoon.silver;

import java.io.*;

public class P10610_S4_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        if(!num.contains("0")) {
            System.out.println("-1");
            return;
        }

        int[] arr = new int[10];
        int sum = 0;
        for(int i=0; i<num.length(); i++) {
            int k = Integer.parseInt(String.valueOf(num.charAt(i)));
            sum += k;
            arr[k]++;
        }

        if(sum%3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            while(arr[i] > 0) {
                sb.append(i);
                arr[i]--;
            }
        }

        System.out.println(sb);
    }
}